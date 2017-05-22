/****/
package yay.lv.wp.entry;

import java.sql.Timestamp;

import lombok.Data;

/**
 * @author liuwp
 * @date 2017年5月6日
 */
@Data
public class BaseEntry {
	private int createTime;
	private Timestamp updateTime;
}
