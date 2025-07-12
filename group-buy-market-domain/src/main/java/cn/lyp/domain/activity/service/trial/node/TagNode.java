package cn.lyp.domain.activity.service.trial.node;

import cn.lyp.domain.activity.model.entity.MarketProductEntity;
import cn.lyp.domain.activity.model.entity.TrialBalanceEntity;
import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.lyp.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.lyp.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.lyp.types.design.framework.tree.StrategyHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: LypCoding
 * @Date: 2025/7/12 11:38
 * @Description:
 */
@Service
public class TagNode extends AbstractGroupBuyMarketSupport<
        MarketProductEntity,
        DefaultActivityStrategyFactory.DynamicContext,
        TrialBalanceEntity> {

    @Resource
    private EndNode endNode;


    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        //获取拼团活动配置
        GroupBuyActivityDiscountVO groupBuyActivityDiscountVO = dynamicContext.getGroupBuyActivityDiscountVO();
        String tagId = groupBuyActivityDiscountVO.getTagId();
        boolean visible = groupBuyActivityDiscountVO.isVisible();
        boolean enable = groupBuyActivityDiscountVO.isEnable();

        //人群标签为空，则走默认值
        if(StringUtils.isBlank(tagId)){
            dynamicContext.setVisible(true);
            dynamicContext.setEnable(true);
            return router(requestParameter,dynamicContext);
        }

        // 是否在人群范围内；visible、enable 如果值为 ture 则表示没有配置拼团限制，那么就直接保证为 true 即可
        boolean isWithin = repository.isTagCrowdRange(tagId, requestParameter.getUserId());
        dynamicContext.setVisible(visible || isWithin);
        dynamicContext.setEnable(enable || isWithin);

        return router(requestParameter,dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return endNode;
    }
}
