/****/
package yay.lv.wp.bo;

import java.sql.Timestamp;

import lombok.Data;

/**
 * @author liuwp
 * @date 2017年5月6日
 */
@Data
public class BaseBo {
	private String createTime;
	private Timestamp updatetTime;
}
