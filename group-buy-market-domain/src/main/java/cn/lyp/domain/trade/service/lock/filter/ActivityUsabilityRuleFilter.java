package cn.lyp.domain.trade.service.lock.filter;

import cn.lyp.domain.trade.adapter.repository.ITradeRepository;
import cn.lyp.domain.trade.model.entity.GroupBuyActivityEntity;
import cn.lyp.domain.trade.model.entity.TradeRuleCommendEntity;
import cn.lyp.domain.trade.model.entity.TradeRuleFilterBackEntity;
import cn.lyp.domain.trade.service.lock.factory.TradeRuleFilterFactory;
import cn.lyp.types.design.framework.link.model2.handler.ILogicHandler;
import cn.lyp.types.enums.ActivityStatusEnumVO;
import cn.lyp.types.enums.ResponseCode;
import cn.lyp.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: LypCoding
 * @Date: 2025/7/19 20:40
 * @Description:
 */
@Slf4j
@Service
public class ActivityUsabilityRuleFilter implements ILogicHandler<TradeRuleCommendEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> {

    @Resource
    private ITradeRepository repository;

    @Override
    public TradeRuleFilterBackEntity apply(TradeRuleCommendEntity requestParameter, TradeRuleFilterFactory.DynamicContext dynamicContext) throws Exception {
        log.info("交易规则过滤-活动可用性校验{} activityId:{}",requestParameter.getUseId(),requestParameter.getActivityId());

        GroupBuyActivityEntity groupBuyActivity= repository.queryGroupBuyActivityByActivityId(requestParameter.getActivityId());

        if(!ActivityStatusEnumVO.EFFECTIVE.equals(groupBuyActivity.getStatus())){
            throw new AppException(ResponseCode.E0101);
        }

        Date currentTime = new Date();
        if(currentTime.before(groupBuyActivity.getStartTime()) || currentTime.after(groupBuyActivity.getEndTime())){
            throw new AppException(ResponseCode.E0102);
        }

        dynamicContext.setGroupBuyActivity(groupBuyActivity);

        return next(requestParameter,dynamicContext);
    }

}
