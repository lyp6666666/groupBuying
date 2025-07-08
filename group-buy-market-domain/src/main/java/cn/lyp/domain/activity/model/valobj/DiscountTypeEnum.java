package cn.lyp.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: LypCoding
 * @Date: 2025/7/8 14:19
 * @Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum DiscountTypeEnum {

    BASE(0,"基础优惠"),
    TAG(1,"人群标签"),
    ;

    private Integer code;
    private String info;

    public static DiscountTypeEnum get(Integer code){
        switch (code){
            case 0:
                return BASE;
            case 1:
                return TAG;
            default:
                throw new RuntimeException("err code!");
        }
    }

}
