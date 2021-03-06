/**
 *
 */
package yay.lv.wp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import yay.lv.wp.biz.utils.Constants;
import yay.lv.wp.bo.userinfo.FloveUser;

/**
 * @author 刘伟平<liuweiping@ wcp.sina.com>
 * @since 2015年10月30日 上午10:41:52
 * @version 1.0
 */
@Slf4j
public class DisjunctorDispatcherInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterConcurrentHandlingStarted(
			final HttpServletRequest request,
			final HttpServletResponse response, final Object handler)
			throws Exception {
	}

	@Override
	public boolean preHandle(final HttpServletRequest request,
			final HttpServletResponse response, final Object handler)
			throws Exception {
		final String url1 = request.getRequestURL().toString();
		final String contextPath = request.getContextPath().toString();
		final HttpSession session = request.getSession();
		// final Cookie[] cc = request.getCookies();
		final Object obj = session.getAttribute(Constants.SESSION_USER);
		log.info("getRequestURL:[" + url1 + "]");
		if (obj == null) {
			log.info("--------当前用户未登录！----------");
			if (isAjaxRequest(request)) {
				// session.setAttribute(Constants.AJAX_REQ, false);
				// return false;
			}
			response.sendRedirect(contextPath + Constants.LOGIN_URL);
			return false;
		} else {
			if (obj instanceof FloveUser) {
				final FloveUser loginUser = (FloveUser) obj;
				if (loginUser != null
						&& !StringUtils.isEmpty(loginUser.getUsername())) {
					// session.setAttribute(Constants.AJAX_REQ, true);
				} else {
					log.info("--------当前用户登录失败！----------");
					if (isAjaxRequest(request)) {
						// session.setAttribute(Constants.AJAX_REQ, false);
						return false;
					} else {
						throw new RuntimeException(
								"--------当前用户登录失败！----------");
					}
				}
			} else {
				// session.setAttribute(Constants.AJAX_REQ, false);
				log.info("---------登录错误！-----------");
				throw new RuntimeException("---------登录错误！-----------");

			}
		}
		return super.preHandle(request, response, handler);
	}

	/**
	 * 判断是否是ajax 请求
	 *
	 * @param request
	 * @return
	 */
	private boolean isAjaxRequest(final HttpServletRequest request) {
		final String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {
			return true;
		}
		return false;
	}
}
