/****/
package yay.lv.wp.biz.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yay.lv.wp.biz.BaseBiz;
import yay.lv.wp.biz.core.ICoreBiz;
import yay.lv.wp.bo.FlovePictureBo;
import yay.lv.wp.condition.PicCondition;
import yay.lv.wp.dao.core.ICoreDao;
import yay.lv.wp.entry.FlovePictureEntry;

/**
 * @author liuwp
 * @date 2017年5月5日
 */
@Service
public class CoreBizImpl extends BaseBiz implements ICoreBiz {
	@Autowired
	private ICoreDao iCoreDao;

	@Override
	public List<FlovePictureBo> getFlovePictureList() {
		final List<FlovePictureEntry> entryList = iCoreDao
				.getFlovePictureList();
		final List<FlovePictureBo> list = mapList(entryList,
				FlovePictureBo.class);
		return list;
	}

	@Override
	public List<FlovePictureBo> getFlovePrictureListByCd(
			final PicCondition condition) {
		final List<FlovePictureEntry> entryList = iCoreDao
				.getFlovePrictureListByCd(condition);
		final List<FlovePictureBo> list = mapList(entryList,
				FlovePictureBo.class);
		return list;
	}
}
