/****/
package yay.lv.wp.dao.core;

import java.util.List;

import org.springframework.stereotype.Repository;

import yay.lv.wp.condition.PicCondition;
import yay.lv.wp.entry.FlovePictureEntry;

/**
 * @author liuwp
 * @date 2017年5月5日
 */
@Repository
public interface ICoreMapper {

	/**
	 * @return
	 */
	List<FlovePictureEntry> getFlovePicture();

	/**
	 * @param condition
	 * @return
	 */
	List<FlovePictureEntry> getFlovePrictureByCondition(
			final PicCondition condition);
}
