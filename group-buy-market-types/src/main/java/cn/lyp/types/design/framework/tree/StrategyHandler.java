package cn.lyp.types.design.framework.tree;

/**
 * @Author: LypCoding
 * @Date: 2025/7/3 10:22
 * @Description: 策略处理器
 */
public interface StrategyHandler<T,D,R>{

    StrategyHandler DEFAULT = (T,D) -> null;

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
