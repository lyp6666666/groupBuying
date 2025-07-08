package cn.lyp.domain.activity.service.discount;

import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @Author: LypCoding
 * @Date: 2025/7/8 14:10
 * @Description:
 */
public interface IDiscountCalculateService {


    /**
     * 折扣计算
     *
     * @param userId            用户ID
     * @param originalPrice      商品原始价格
     * @param groupBuyDiscount   折扣计算配置
     * @return 商品优惠价格
     */
    BigDecimal calculate(String userId , BigDecimal originalPrice , GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

}
