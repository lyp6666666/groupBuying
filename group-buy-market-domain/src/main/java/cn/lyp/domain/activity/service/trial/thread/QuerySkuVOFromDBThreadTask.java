package cn.lyp.domain.activity.service.trial.thread;

import cn.lyp.domain.activity.adapter.repository.IActivityRepository;
import cn.lyp.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

/**
 * @Author: LypCoding
 * @Date: 2025/7/7 14:24
 * @Description:
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {


    private final String goodId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodId, IActivityRepository activityRepository) {
        this.goodId = goodId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodId);
    }
}
