package cn.lyp.domain.activity.service.trial.factory;

import cn.lyp.domain.activity.model.entity.MarketProductEntity;
import cn.lyp.domain.activity.model.entity.TrialBalanceEntity;
import cn.lyp.domain.activity.service.trial.node.RootNode;
import cn.lyp.types.design.framework.tree.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;



/**
 * @Author: LypCoding
 * @Date: 2025/7/3 11:34
 * @Description:
 */
@Service
public class DefaultActivityStrategyFactory {


    private final RootNode rootNode;

    public DefaultActivityStrategyFactory(RootNode rootNode){
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity,
            DefaultActivityStrategyFactory.DynamicContext,
            TrialBalanceEntity> strategyHandler(){
        return rootNode;
    }




    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext{

    }

}
