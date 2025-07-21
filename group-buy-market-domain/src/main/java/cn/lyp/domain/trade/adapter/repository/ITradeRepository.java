package cn.lyp.domain.trade.adapter.repository;

import cn.lyp.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import cn.lyp.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import cn.lyp.domain.trade.model.entity.GroupBuyActivityEntity;
import cn.lyp.domain.trade.model.entity.GroupBuyTeamEntity;
import cn.lyp.domain.trade.model.entity.MarketPayOrderEntity;
import cn.lyp.domain.trade.model.valobj.GroupBuyProgressVO;

/**
 * @Author: LypCoding
 * @Date: 2025/7/16 22:04
 * @Description:
 */
public interface ITradeRepository {


    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    GroupBuyActivityEntity queryGroupBuyActivityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String useId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    void settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);
}
