/****/
package yay.lv.wp.entry;

import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.annotation.Id;

/**
 * @author liuwp
 * @date 2017年5月5日
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FlovePictureEntry extends BaseEntry {
	private int createTime;
	private String date;
	@Id
	private Long id;
	private String photoTime;
	private String remarks;
	private int state;
	private int tag;
	private Long uid;
	private Timestamp updateTime;
	private String url;

}
