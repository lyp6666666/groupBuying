package cn.lyp.types.design.framework.link.model2.handler;

/**
 * @Author: LypCoding
 * @Date: 2025/7/17 16:10
 * @Description: 逻辑处理器
 */
public interface ILogicHandler<T, D, R> {

    default R next(T requestParameter, D dynamicContext) {
        return null;
    }

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
