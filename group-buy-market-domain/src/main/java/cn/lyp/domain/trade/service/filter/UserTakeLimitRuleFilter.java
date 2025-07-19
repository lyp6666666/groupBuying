package cn.lyp.domain.trade.service.filter;

import cn.lyp.domain.trade.adapter.repository.ITradeRepository;
import cn.lyp.domain.trade.model.entity.GroupBuyActivityEntity;
import cn.lyp.domain.trade.model.entity.TradeRuleCommendEntity;
import cn.lyp.domain.trade.model.entity.TradeRuleFilterBackEntity;
import cn.lyp.domain.trade.service.factory.TradeRuleFilterFactory;
import cn.lyp.types.design.framework.link.model2.handler.ILogicHandler;
import cn.lyp.types.enums.ResponseCode;
import cn.lyp.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: LypCoding
 * @Date: 2025/7/19 20:41
 * @Description:
 */
@Slf4j
@Service
public class UserTakeLimitRuleFilter implements ILogicHandler<TradeRuleCommendEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> {

    @Resource
    private ITradeRepository repository;

    @Override
    public TradeRuleFilterBackEntity apply(TradeRuleCommendEntity requestParameter, TradeRuleFilterFactory.DynamicContext dynamicContext) throws Exception {

        GroupBuyActivityEntity groupBuyActivity = dynamicContext.getGroupBuyActivity();

        Integer count =  repository.queryOrderCountByActivityId(requestParameter.getActivityId(),requestParameter.getUseId());
        if(null != groupBuyActivity.getTakeLimitCount() && count >= groupBuyActivity.getTakeLimitCount()){
            throw new AppException(ResponseCode.E0103);
        }



        return TradeRuleFilterBackEntity.builder()
                .userTakeOrderCount(count)
                .build();
    }


}
