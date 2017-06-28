/****/
package yay.lv.wp.action.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yay.lv.wp.biz.core.ICoreBiz;
import yay.lv.wp.bo.FlovePictureBo;
import yay.lv.wp.condition.PicCondition;

/**
 * @author liuwp
 * @date 2017年3月15日
 */
@Controller
@RequestMapping("core")
public class CoreAction {

	@Autowired
	private ICoreBiz iCoreBiz;

	public ModelAndView getPicture() {
		final ModelAndView model = new ModelAndView();
		return model;
	}

	/**
	 *
	 * 首页
	 */
	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public ModelAndView index() {
		final ModelAndView model = new ModelAndView();
		final Map<String, Object> modelMap = new HashMap<String, Object>();
		final List<FlovePictureBo> list = iCoreBiz.getFlovePictureList();
		modelMap.put("list", list);
		modelMap.put("count", list.size());
		model.addAllObjects(modelMap);
		// model.setViewName("temp");
		model.setViewName("time_index");
		return model;
	}

	@RequestMapping(value = "pic.html", method = RequestMethod.GET)
	public ModelAndView picdialog(
			@RequestParam(value = "uid", required = true) final Long uid,
			@RequestParam(value = "date", required = true) final String date) {
		final ModelAndView model = new ModelAndView();
		final Map<String, Object> modelMap = new HashMap<String, Object>();
		final PicCondition condition = new PicCondition();
		condition.setUid(uid);
		condition.setDate(date);
		final List<FlovePictureBo> list = iCoreBiz
				.getFlovePrictureListByCd(condition);
		modelMap.put("list", list);
		modelMap.put("count", list.size());
		model.addAllObjects(modelMap);
		model.setViewName("pic_dialog");
		return model;
	}
}
