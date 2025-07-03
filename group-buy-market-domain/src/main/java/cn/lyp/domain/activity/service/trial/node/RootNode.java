package cn.lyp.domain.activity.service.trial.node;

import cn.lyp.domain.activity.model.entity.MarketProductEntity;
import cn.lyp.domain.activity.model.entity.TrialBalanceEntity;
import cn.lyp.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.lyp.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.lyp.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: LypCoding
 * @Date: 2025/7/3 14:01
 * @Description: 根节点
 */
@Slf4j
@Service
public class RootNode
        extends AbstractGroupBuyMarketSupport<MarketProductEntity,
        DefaultActivityStrategyFactory.DynamicContext,
        TrialBalanceEntity> {

    @Resource
    private SwitchNode switchNode;


    @Override
    public Object apply(Object requestParameter, Object dynamicContext) throws Exception {


        return null;
    }


    @Override
    public StrategyHandler get(Object requestParameter, Object dynamicContext) {
        return switchNode;
    }
}
