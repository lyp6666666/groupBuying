package cn.lyp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LypCoding
 * @Date: 2025/8/4 23:45
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SettlementMarketPayOrderResponseDTO {

    /** 用户ID */
    private String userId;
    /** 拼单组队ID */
    private String teamId;
    /** 活动ID */
    private Long activityId;
    /** 外部交易单号 */
    private String outTradeNo;

}
