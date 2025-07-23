package cn.lyp.domain.trade.service.settlement.factory;

import cn.lyp.domain.trade.model.entity.GroupBuyTeamEntity;
import cn.lyp.domain.trade.model.entity.MarketPayOrderEntity;
import cn.lyp.domain.trade.model.entity.TradeSettlementRuleCommandEntity;
import cn.lyp.domain.trade.model.entity.TradeSettlementRuleFilterBackEntity;
import cn.lyp.domain.trade.service.settlement.filter.EndRuleFilter;
import cn.lyp.domain.trade.service.settlement.filter.OutTradeNoRuleFilter;
import cn.lyp.domain.trade.service.settlement.filter.SCRuleFilter;
import cn.lyp.domain.trade.service.settlement.filter.SettableRuleFilter;
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
 * @Date: 2025/7/23 23:39
 * @Description:
 */
@Slf4j
@Service
public class TradeSettlementRuleFilterFactory {

    @Bean("tradeSettlementRuleFilter")
    public BusinessLinkedList<TradeSettlementRuleCommandEntity,
                DynamicContext, TradeSettlementRuleFilterBackEntity> tradeSettlementRuleFilter(
            SCRuleFilter scRuleFilter,
            OutTradeNoRuleFilter outTradeNoRuleFilter,
            SettableRuleFilter settableRuleFilter,
            EndRuleFilter endRuleFilter) {

        // 组装链
        LinkArmory<TradeSettlementRuleCommandEntity, DynamicContext, TradeSettlementRuleFilterBackEntity> linkArmory =
                new LinkArmory<>("交易结算规则过滤链", scRuleFilter, outTradeNoRuleFilter, settableRuleFilter, endRuleFilter);

        // 链对象
        return linkArmory.getLogicLink();
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {
        // 订单营销实体对象
        private MarketPayOrderEntity marketPayOrderEntity;
        // 拼团组队实体对象
        private GroupBuyTeamEntity groupBuyTeamEntity;
    }

}
