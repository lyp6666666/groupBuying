package cn.lyp.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS("0000", "成功"),
    UN_ERROR("0001", "未知失败"),
    ILLEGAL_PARAMETER("0002", "非法参数"),
    E0001("E0001", "不存在对应的折扣计算服务"),
    E0002("E0002","无拼团营销配置")
    ;

    private String code;
    private String info;

}
