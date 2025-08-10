package cn.lyp.domain.trade.adapter.repository;

import cn.lyp.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import cn.lyp.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import cn.lyp.domain.trade.model.entity.GroupBuyActivityEntity;
import cn.lyp.domain.trade.model.entity.GroupBuyTeamEntity;
import cn.lyp.domain.trade.model.entity.MarketPayOrderEntity;
import cn.lyp.domain.trade.model.entity.NotifyTaskEntity;
import cn.lyp.domain.trade.model.valobj.GroupBuyProgressVO;

import java.util.List;

/**
 * @Author: LypCoding
 * @Date: 2025/7/16 22:04
 * @Description:
 */
public interface ITradeRepository {

    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    GroupBuyActivityEntity queryGroupBuyActivityEntityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    NotifyTaskEntity settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);

    boolean isSCBlackIntercept(String source, String channel);

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList();

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList(String teamId);

    int updateNotifyTaskStatusSuccess(String teamId);

    int updateNotifyTaskStatusError(String teamId);

    int updateNotifyTaskStatusRetry(String teamId);

}
