package cn.lyp.api.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: LypCoding
 * @Date: 2025/7/29 0:47
 * @Description:
 */
@Data
public class NotifyRequestDTO {

    /** 组队ID */
    private String teamId;
    /** 外部单号 */
    private List<String> outTradeNoList;

}

