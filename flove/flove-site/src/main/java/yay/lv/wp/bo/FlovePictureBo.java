/****/
package yay.lv.wp.bo;

import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liuwp
 * @date 2017年5月5日
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FlovePictureBo extends BaseBo {
	private String createTime;
	private String date;
	private Long id;
	private String photoTime;
	private String remarks;
	private int state;
	private int tag;
	private Long uid;
	private Timestamp updatetTime;
	private String url;
}
