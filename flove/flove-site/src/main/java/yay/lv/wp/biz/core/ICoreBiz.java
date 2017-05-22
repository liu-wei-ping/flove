/****/
package yay.lv.wp.biz.core;

import java.util.List;

import yay.lv.wp.bo.FlovePictureBo;
import yay.lv.wp.condition.PicCondition;

/**
 * @author liuwp
 * @date 2017年5月5日
 */
public interface ICoreBiz {

	/**
	 * @return
	 */
	List<FlovePictureBo> getFlovePictureList();

	/**
	 * @param condition
	 * @return
	 */
	List<FlovePictureBo> getFlovePrictureListByCd(final PicCondition condition);
}
