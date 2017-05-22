/****/
package yay.lv.wp.action.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yay.lv.wp.biz.utils.Constants;
import yay.lv.wp.biz.utils.IdCodeUtil;
import yay.lv.wp.bo.userinfo.FloveUser;

/**
 * @author mr.lwp
 * @see 2016年5月15日
 */
@Controller
@RequestMapping("login")
public class LoginAction {

	/**
	 * 验证码
	 *
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value = "/code.shtml")
	public void identifyingCode(final HttpServletRequest req,
			final HttpServletResponse resp) {
		try {
			IdCodeUtil.getCode(req, resp);
		} catch (final IOException var4) {
			var4.printStackTrace();
		}

	}

	/**
	 * 登录页
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login.html")
	public ModelAndView login(final HttpSession session,
			final HttpServletResponse response) {
		final ModelAndView model = new ModelAndView();
		final Object code = session.getAttribute(Constants.LOGIN_CODE);
		model.addObject("code", code);
		model.setViewName("login");
		return model;
	}

	/**
	 * 退出
	 *
	 * @param session
	 * @param attr
	 * @return
	 */
	@RequestMapping(value = "/quit.html")
	public String quit(final HttpSession session, final RedirectAttributes attr) {
		session.invalidate();
		return "redirect:/login.html";
	}

	/**
	 * 注册
	 *
	 * @return
	 */
	@RequestMapping("/register.html")
	public String register() {
		return "register";
	}

	/**
	 * 修改密码
	 *
	 * @return
	 */
	@RequestMapping("/retrieve.html")
	public String retrieve() {
		return "retrievepwd";
	}

	/**
	 * @param userInfo
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sign.shtml", method = RequestMethod.POST)
	public Map<String, Object> sign(@RequestBody final FloveUser userInfo,
			final HttpServletRequest request, final HttpServletResponse response) {
		final Map<String, Object> map = new HashMap<String, Object>();
		final HttpSession session = request.getSession();
		userInfo.setUid(1001);
		session.setAttribute(Constants.SESSION_USER, userInfo);
		map.put("success", true);
		return map;
	}
}
