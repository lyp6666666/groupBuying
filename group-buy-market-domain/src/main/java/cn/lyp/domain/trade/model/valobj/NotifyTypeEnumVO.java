package cn.lyp.domain.trade.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: LypCoding
 * @Date: 2025/8/10 13:19
 * @Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum NotifyTypeEnumVO {

    HTTP("HTTP", "HTTP 回调"),
    MQ("MQ", "MQ 消息通知"),
    ;

    private String code;
    private String info;

}
