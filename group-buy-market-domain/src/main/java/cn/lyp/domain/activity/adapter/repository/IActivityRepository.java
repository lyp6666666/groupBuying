package cn.lyp.domain.activity.adapter.repository;

import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.lyp.domain.activity.model.valobj.SCSkuActivityVO;
import cn.lyp.domain.activity.model.valobj.SkuVO;

/**
 * @Author: LypCoding
 * @Date: 2025/7/7 1:38
 * @Description:
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);


    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);
}
