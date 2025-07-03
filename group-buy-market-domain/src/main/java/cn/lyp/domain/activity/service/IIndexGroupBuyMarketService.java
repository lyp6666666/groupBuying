package cn.lyp.domain.activity.service;

import cn.lyp.domain.activity.model.entity.MarketProductEntity;
import cn.lyp.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @Author: LypCoding
 * @Date: 2025/7/3 14:21
 * @Description:
 */
public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
