package cn.lyp.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: LypCoding
 * @Date: 2025/7/3 10:44
 * @Description:策略路由器抽象类:
 * 根据请求参数 T 和上下文 D 路由出一个合适的策略（StrategyHandler），然后由该策略来处理逻辑，返回结果 R。
 */
public abstract class AbstractStrategyRouter<T,D,R> implements StrategyMapper,StrategyHandler{

    @Getter
    @Setter
    protected StrategyHandler<T,D,R> defaultStrategyHandler = StrategyHandler.DEFAULT;


    public R router(T requestParameter , D dynamicContext) throws Exception{
        StrategyHandler<T,D,R> strategyHandler = get(requestParameter, dynamicContext);   //下一个要执行的策略
        if(strategyHandler != null){
            return strategyHandler.apply(requestParameter, dynamicContext);
        }
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }


}
