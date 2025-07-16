package cn.lyp.api;

import cn.lyp.api.dto.LockMarketPayOrderRequestDTO;
import cn.lyp.api.dto.LockMarketPayOrderResponseDTO;
import cn.lyp.api.response.Response;

/**
 * @Author: LypCoding
 * @Date: 2025/7/16 21:50
 * @Description:
 */
public interface IMarketTradeService {

    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarketPayOrderRequestDTO);


}
