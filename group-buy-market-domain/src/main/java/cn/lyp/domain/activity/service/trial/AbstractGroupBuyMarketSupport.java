package cn.lyp.domain.activity.service.trial;


import cn.lyp.domain.activity.adapter.repository.IActivityRepository;
import cn.lyp.domain.activity.model.entity.MarketProductEntity;
import cn.lyp.domain.activity.model.entity.TrialBalanceEntity;
import cn.lyp.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.lyp.types.design.framework.tree.AbstractMultiThreadStrategyRouter;
import cn.lyp.types.design.framework.tree.AbstractStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: LypCoding
 * @Date: 2025/7/3 11:29
 * @Description:
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<cn.lyp.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, cn.lyp.domain.activity.model.entity.TrialBalanceEntity> {

    protected long timeout =  500;

    @Resource
    protected IActivityRepository repository;


    @Override
    protected void multiThread(cn.lyp.domain.activity.model.entity.MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {
        //缺省的方法
    }
}
