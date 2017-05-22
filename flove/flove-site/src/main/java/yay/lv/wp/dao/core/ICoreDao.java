/****/
package yay.lv.wp.dao.core;

import java.util.List;

import yay.lv.wp.condition.PicCondition;
import yay.lv.wp.entry.FlovePictureEntry;

/**
 * @author liuwp
 * @date 2017年5月5日
 */
public interface ICoreDao {
	/**
	 * @return
	 */
	List<FlovePictureEntry> getFlovePictureList();

	/**
	 * @param condition
	 * @return
	 */
	List<FlovePictureEntry> getFlovePrictureListByCd(
			final PicCondition condition);
}
