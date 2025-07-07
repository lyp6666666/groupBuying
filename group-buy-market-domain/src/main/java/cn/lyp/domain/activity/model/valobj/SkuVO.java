package cn.lyp.domain.activity.model.valobj;

import lombok.*;

import java.math.BigDecimal;

/**
 * @Author: LypCoding
 * @Date: 2025/7/7 13:47
 * @Description:
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuVO {

    /** 商品ID */
    private String goodsId;
    /** 商品名称 */
    private String goodsName;
    /** 原始价格 */
    private BigDecimal originalPrice;

}
