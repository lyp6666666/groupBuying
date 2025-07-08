package cn.lyp.domain.activity.service.discount.impl;

import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.lyp.domain.activity.service.discount.AbstractDiscountCalculateService;
import cn.lyp.domain.activity.service.discount.IDiscountCalculateService;
import cn.lyp.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: LypCoding
 * @Date: 2025/7/8 14:53
 * @Description:
 */
@Slf4j
@Service("MJ")
public class MJCalculateService extends AbstractDiscountCalculateService {

    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        log.info("优惠策略折扣计算:{}", groupBuyDiscount.getDiscountType().getCode());

        //折扣表达式 -100，10 满100减10元
        String marketExpr = groupBuyDiscount.getMarketExpr();
        String[] split = marketExpr.split(Constants.SPLIT);
        BigDecimal x = new BigDecimal(split[0].trim());
        BigDecimal y = new BigDecimal(split[1].trim());

        //折扣价格
        BigDecimal deductionPrice = originalPrice.subtract(y);

        //判断折扣后金额，最低支付1分钱
        if(deductionPrice.compareTo(BigDecimal.ZERO) <= 0){
            return new BigDecimal("0.01");
        }

        return deductionPrice;
    }
}
