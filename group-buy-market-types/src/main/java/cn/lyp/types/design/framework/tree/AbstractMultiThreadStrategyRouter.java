package cn.lyp.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: LypCoding
 * @Date: 2025/7/7 1:00
 * @Description:
 */
public abstract class AbstractMultiThreadStrategyRouter<T,D,R> implements StrategyMapper<T,D,R>,StrategyHandler<T,D,R>{


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


    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        //异步加载数据
        multiThread(requestParameter,dynamicContext);
        //业务逻辑受理
        return doApply(requestParameter,dynamicContext);
    }

    protected abstract void multiThread(T requestParameter, D dynamicContext) throws ExecutionException, InterruptedException, TimeoutException;

    protected abstract R doApply(T requestParameter, D dynamicContext) throws Exception;




}


















