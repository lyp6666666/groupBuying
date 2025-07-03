package cn.lyp.types.design.framework.tree;

/**
 * @Author: LypCoding
 * @Date: 2025/7/3 10:15
 * @Description: 策略映射器
 */
public interface StrategyMapper<T,D,R> {

    StrategyHandler<T,D,R> get(T requestParameter, D dynamicContext);

}
