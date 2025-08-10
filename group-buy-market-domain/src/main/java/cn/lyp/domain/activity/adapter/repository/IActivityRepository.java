package cn.lyp.domain.activity.adapter.repository;

import cn.lyp.domain.activity.model.entity.UserGroupBuyOrderDetailEntity;
import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.lyp.domain.activity.model.valobj.SCSkuActivityVO;
import cn.lyp.domain.activity.model.valobj.SkuVO;
import cn.lyp.domain.activity.model.valobj.TeamStatisticVO;

import java.util.List;

/**
 * @Author: LypCoding
 * @Date: 2025/7/7 1:38
 * @Description:
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);

    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);

    boolean isTagCrowdRange(String tagId, String userId);

    boolean downgradeSwitch();

    boolean cutRange(String userId);

    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailListByOwner(Long activityId, String userId, Integer ownerCount);

    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailListByRandom(Long activityId, String userId, Integer randomCount);

    TeamStatisticVO queryTeamStatisticByActivityId(Long activityId);
}
