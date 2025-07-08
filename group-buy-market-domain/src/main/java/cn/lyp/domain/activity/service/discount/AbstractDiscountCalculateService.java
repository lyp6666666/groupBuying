package cn.lyp.domain.activity.service.discount;

import cn.lyp.domain.activity.model.valobj.DiscountTypeEnum;
import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @Author: LypCoding
 * @Date: 2025/7/8 14:13
 * @Description:
 */
public abstract class AbstractDiscountCalculateService implements  IDiscountCalculateService{


    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        //1. 人群标签过滤
        if (DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())){
            boolean isCrowdRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if (!isCrowdRange) return originalPrice;
        }
        //2. 折扣优惠计算
        return doCalculate(originalPrice, groupBuyDiscount);
    }

    //人群过滤 - 限定人群数量
    private boolean filterTagId(String userId , String tagId){
        //todo 后续开发

        return true;
    }


    protected abstract BigDecimal doCalculate(BigDecimal originalPrice ,GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

}
