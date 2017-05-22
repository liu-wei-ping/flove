/****/
package yay.lv.wp.dao.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import yay.lv.wp.condition.PicCondition;
import yay.lv.wp.dao.core.ICoreDao;
import yay.lv.wp.dao.core.ICoreMapper;
import yay.lv.wp.entry.FlovePictureEntry;

/**
 * @author liuwp
 * @date 2017年5月5日
 */
@Repository
class CoreDaoImpl implements ICoreDao {
	@Autowired
	private ICoreMapper mapper;

	@Override
	public List<FlovePictureEntry> getFlovePictureList() {
		final List<FlovePictureEntry> list = mapper.getFlovePicture();
		return list;
	}

	@Override
	public List<FlovePictureEntry> getFlovePrictureListByCd(
			final PicCondition condition) {
		final List<FlovePictureEntry> list = mapper
				.getFlovePrictureByCondition(condition);
		return list;
	}

}
