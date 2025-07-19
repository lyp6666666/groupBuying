package cn.lyp.domain.trade.model.entity;

import cn.lyp.types.enums.ActivityStatusEnumVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: LypCoding
 * @Date: 2025/7/19 20:52
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyActivityEntity {

    /** 活动ID */
    private Long activityId;
    /** 活动名称 */
    private String activityName;
    /** 来源 */
    private String source;
    /** 渠道 */
    private String channel;
    /** 商品ID */
    private String goodsId;
    /** 折扣ID */
    private String discountId;
    /** 拼团方式（0自动成团、1达成目标拼团） */
    private Integer groupType;
    /** 拼团次数限制 */
    private Integer takeLimitCount;
    /** 拼团目标 */
    private Integer target;
    /** 拼团时长（分钟） */
    private Integer validTime;
    /** 活动状态（0创建、1生效、2过期、3废弃） */
    private ActivityStatusEnumVO status;
    /** 活动开始时间 */
    private Date startTime;
    /** 活动结束时间 */
    private Date endTime;
    /** 人群标签规则标识 */
    private String tagId;
    /** 人群标签规则范围 */
    private String tagScope;


}
