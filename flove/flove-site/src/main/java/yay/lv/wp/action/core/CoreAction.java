/****/
package yay.lv.wp.action.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuwp
 * @date 2017年3月15日
 */
@Controller
@RequestMapping("core")
public class CoreAction {
	/**
	 *
	 * 首页
	 */
	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public ModelAndView index() {
		final ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
}
