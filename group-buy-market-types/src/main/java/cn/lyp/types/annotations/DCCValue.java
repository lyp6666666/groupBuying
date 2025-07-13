package cn.lyp.types.annotations;

import java.lang.annotation.*;

/**
 * @Author: LypCoding
 * @Date: 2025/7/13 12:25
 * @Description: 注解，动态配置中心标记
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface DCCValue {

    String value() default "";

}
