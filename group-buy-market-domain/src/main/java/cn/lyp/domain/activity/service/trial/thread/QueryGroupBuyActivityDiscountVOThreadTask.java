package cn.lyp.domain.activity.service.trial.thread;

import cn.lyp.domain.activity.adapter.repository.IActivityRepository;
import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.lyp.domain.activity.model.valobj.SCSkuActivityVO;

import java.util.concurrent.Callable;

/**
 * @Author: LypCoding
 * @Date: 2025/7/7 13:52
 * @Description:
 */
public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    /** 来源 */
    private final String source;

    /** 渠道 */
    private final String channel;

    /** 商品ID */
    private final String goodsId;

    /** 活动仓储 */
    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel, String goodsId, IActivityRepository activityRepository) {
        this.source = source;
        this.channel = channel;
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        // 查询渠道商品活动配置关联配置
        SCSkuActivityVO scSkuActivityVO = activityRepository.querySCSkuActivityBySCGoodsId(source, channel, goodsId);
        if (null == scSkuActivityVO) return null;
        // 查询活动配置
        return activityRepository.queryGroupBuyActivityDiscountVO(scSkuActivityVO.getActivityId());
    }

}
