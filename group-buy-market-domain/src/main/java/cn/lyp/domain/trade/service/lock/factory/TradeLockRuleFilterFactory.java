package cn.lyp.domain.trade.service.lock.factory;

import cn.lyp.domain.trade.model.entity.GroupBuyActivityEntity;
import cn.lyp.domain.trade.model.entity.TradeLockRuleCommandEntity;
import cn.lyp.domain.trade.model.entity.TradeLockRuleFilterBackEntity;
import cn.lyp.domain.trade.service.lock.filter.ActivityUsabilityRuleFilter;
import cn.lyp.domain.trade.service.lock.filter.UserTakeLimitRuleFilter;
import cn.lyp.types.design.framework.link.model2.LinkArmory;
import cn.lyp.types.design.framework.link.model2.chain.BusinessLinkedList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @Author: LypCoding
 * @Date: 2025/7/19 20:32
 * @Description: 编排责任链,然后返回一个对应的Bean对象，方便使用
 */
@Slf4j
@Service
public class TradeLockRuleFilterFactory {

    @Bean("tradeRuleFilter")
    public BusinessLinkedList<TradeLockRuleCommandEntity, TradeLockRuleFilterFactory.DynamicContext, TradeLockRuleFilterBackEntity> tradeRuleFilter(ActivityUsabilityRuleFilter activityUsabilityRuleFilter, UserTakeLimitRuleFilter userTakeLimitRuleFilter) {
        // 组装链
        LinkArmory<TradeLockRuleCommandEntity, TradeLockRuleFilterFactory.DynamicContext, TradeLockRuleFilterBackEntity> linkArmory =
                new LinkArmory<>("交易规则过滤链", activityUsabilityRuleFilter, userTakeLimitRuleFilter);

        // 链对象
        return linkArmory.getLogicLink();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        private GroupBuyActivityEntity groupBuyActivity;

    }

}
