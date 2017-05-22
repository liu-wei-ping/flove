/****/
package yay.lv.wp.action.im.msn;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yay.lv.wp.biz.utils.Constants;
import yay.lv.wp.bo.userinfo.FloveUser;

/**
 * @author liuwp
 * @date 2017年5月18日
 */
@Controller
@RequestMapping("msnCore")
public class MsnCoreAction {
	@ResponseBody
	@RequestMapping(value = "sendMsn", method = RequestMethod.POST)
	public Map<String, Object> sendMsn(
			@RequestParam(value = "msn", required = true) final String msn,
			final HttpSession session) {
		final FloveUser userInfo = (FloveUser) session
				.getAttribute(Constants.SESSION_USER);
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", Constants.SUCCESS);
		map.put("uid", userInfo.getUid());
		return map;
	}
}
