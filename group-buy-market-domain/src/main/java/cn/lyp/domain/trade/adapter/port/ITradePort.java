package cn.lyp.domain.trade.adapter.port;

import cn.lyp.domain.trade.model.entity.NotifyTaskEntity;

/**
 * @Author: LypCoding
 * @Date: 2025/7/29 0:29
 * @Description:
 */
public interface ITradePort {

    String groupBuyNotify(NotifyTaskEntity notifyTask) throws Exception;

}
