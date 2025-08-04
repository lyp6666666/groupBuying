package cn.lyp.api;

import cn.lyp.api.dto.GoodsMarketRequestDTO;
import cn.lyp.api.dto.GoodsMarketResponseDTO;
import cn.lyp.api.response.Response;

/**
 * @Author: LypCoding
 * @Date: 2025/8/5 0:10
 * @Description:
 */
public interface IMarketIndexService {


    /**
     * 查询拼团营销配置
     *
     * @param goodsMarketRequestDTO 营销商品信息
     * @return 营销配置信息
     */
    Response<GoodsMarketResponseDTO> queryGroupBuyMarketConfig(GoodsMarketRequestDTO goodsMarketRequestDTO);
}
