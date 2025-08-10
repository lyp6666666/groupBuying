package cn.lyp.domain.trade.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: LypCoding
 * @Date: 2025/8/10 13:19
 * @Description:
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotifyConfigVO {

    /**
     * 回调方式；MQ、HTTP
     */
    private NotifyTypeEnumVO notifyType;
    /**
     * 回调消息
     */
    private String notifyMQ;
    /**
     * 回调地址
     */
    private String notifyUrl;

}
