package cn.lyp.domain.activity.service.trial.node;

import cn.lyp.domain.activity.model.entity.MarketProductEntity;
import cn.lyp.domain.activity.model.entity.TrialBalanceEntity;
import cn.lyp.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.lyp.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.lyp.types.design.framework.tree.StrategyHandler;
import cn.lyp.types.enums.ResponseCode;
import cn.lyp.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: LypCoding
 * @Date: 2025/7/3 14:10
 * @Description: 功能节点
 */
@Slf4j
@Service
public class SwitchNode
        extends AbstractGroupBuyMarketSupport<
        MarketProductEntity,
        DefaultActivityStrategyFactory.DynamicContext,
        TrialBalanceEntity> {

    @Resource
    private MarketNode marketNode;

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {

        String userId = requestParameter.getUserId();
        if(repository.downgradeSwitch()){
            throw new AppException(ResponseCode.E0003.getCode(),ResponseCode.E0003.getInfo());
        }
        if(repository.cutRange(userId)){
            throw new AppException(ResponseCode.E0004.getCode(),ResponseCode.E0004.getInfo());
        }

        return router(requestParameter,dynamicContext);
    }

    @Override
    public StrategyHandler<
            MarketProductEntity,
            DefaultActivityStrategyFactory.DynamicContext,
            TrialBalanceEntity>
    get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception{
        return marketNode;
    }
}
