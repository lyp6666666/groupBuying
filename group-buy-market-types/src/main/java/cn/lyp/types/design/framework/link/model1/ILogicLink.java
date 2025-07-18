package cn.lyp.types.design.framework.link.model1;

/**
 * @Author: LypCoding
 * @Date: 2025/7/17 15:43
 * @Description: 继承并提供一个受理业务逻辑的方法
 */
public interface ILogicLink<T,D,R> extends ILogicChainArmory<T,D,R>{

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
