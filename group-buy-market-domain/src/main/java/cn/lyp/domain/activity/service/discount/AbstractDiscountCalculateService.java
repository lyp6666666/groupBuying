package cn.lyp.domain.activity.service.discount;

import cn.lyp.domain.activity.adapter.repository.IActivityRepository;
import cn.lyp.domain.activity.model.valobj.DiscountTypeEnum;
import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: LypCoding
 * @Date: 2025/7/8 14:13
 * @Description:
 */
@Slf4j
public abstract class AbstractDiscountCalculateService implements  IDiscountCalculateService{

    @Resource
    protected IActivityRepository repository;

    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        //1. 人群标签过滤
        if (DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())){
            boolean isCrowdRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if (!isCrowdRange){
                log.info("折扣优惠计算拦截 userId:{}",userId);
                return originalPrice;
            }
        }
        //2. 折扣优惠计算
        return doCalculate(originalPrice, groupBuyDiscount);
    }

    //人群过滤 - 限定人群数量
    private boolean filterTagId(String userId , String tagId){
        return repository.isTagCrowdRange(tagId,userId);
    }


    protected abstract BigDecimal doCalculate(BigDecimal originalPrice ,GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

}
