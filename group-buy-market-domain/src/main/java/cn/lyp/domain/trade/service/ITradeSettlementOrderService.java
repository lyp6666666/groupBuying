package cn.lyp.domain.trade.service;

import cn.lyp.domain.trade.model.entity.TradePaySettlementEntity;
import cn.lyp.domain.trade.model.entity.TradePaySuccessEntity;

/**
 * @Author: LypCoding
 * @Date: 2025/7/21 23:53
 * @Description: 交易结算接口
 */
public interface ITradeSettlementOrderService {

    /**
     * 营销结算
     * @param tradePaySuccessEntity 交易支付订单实体对象
     * @return 交易结算订单实体
     */
    TradePaySettlementEntity settlementMarketPayOrder(TradePaySuccessEntity tradePaySuccessEntity);

}
