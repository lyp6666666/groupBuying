package cn.lyp.domain.activity.service.trial;


import cn.lyp.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.lyp.types.design.framework.tree.AbstractStrategyRouter;

/**
 * @Author: LypCoding
 * @Date: 2025/7/3 11:29
 * @Description:
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity , DynamicContext ,TrialBalanceEntity>
        extends AbstractStrategyRouter<
        cn.lyp.domain.activity.model.entity.MarketProductEntity,
        DefaultActivityStrategyFactory.DynamicContext,
        cn.lyp.domain.activity.model.entity.TrialBalanceEntity> {



}
