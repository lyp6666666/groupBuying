package cn.lyp.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LypCoding
 * @Date: 2025/7/19 20:24
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeRuleCommendEntity {

    private String useId;
    private Long activityId;

}
