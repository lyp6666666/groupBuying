package cn.lyp.api;

import cn.lyp.api.dto.LockMarketPayOrderRequestDTO;
import cn.lyp.api.dto.LockMarketPayOrderResponseDTO;
import cn.lyp.api.dto.SettlementMarketPayOrderRequestDTO;
import cn.lyp.api.dto.SettlementMarketPayOrderResponseDTO;
import cn.lyp.api.response.Response;

/**
 * @Author: LypCoding
 * @Date: 2025/7/16 21:50
 * @Description:
 */
public interface IMarketTradeService {

    /**
     * 营销锁单
     *
     * @param requestDTO 锁单商品信息
     * @return 锁单结果信息
     */
    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO requestDTO);

    /**
     * 营销结算
     *
     * @param requestDTO 结算商品信息
     * @return 结算结果信息
     */
    Response<SettlementMarketPayOrderResponseDTO> settlementMarketPayOrder(SettlementMarketPayOrderRequestDTO requestDTO);

}
