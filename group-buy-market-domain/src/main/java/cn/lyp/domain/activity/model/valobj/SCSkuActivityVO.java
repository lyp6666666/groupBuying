package cn.lyp.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: LypCoding
 * @Date: 2025/7/11 20:32
 * @Description:
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SCSkuActivityVO {

    /** 渠道 */
    private String source;
    /** 来源 */
    private String chanel;
    /** 活动ID */
    private Long activityId;
    /** 商品ID */
    private String goodsId;

}
