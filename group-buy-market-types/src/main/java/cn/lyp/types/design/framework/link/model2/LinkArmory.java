package cn.lyp.types.design.framework.link.model2;

import cn.lyp.types.design.framework.link.model2.chain.BusinessLinkedList;
import cn.lyp.types.design.framework.link.model2.handler.ILogicHandler;

/**
 * @Author: LypCoding
 * @Date: 2025/7/17 16:46
 * @Description:
 */
public class LinkArmory<T, D, R> {

    private final BusinessLinkedList<T, D, R> logicLink;

    @SafeVarargs
    public LinkArmory(String linkName, ILogicHandler<T, D, R>... logicHandlers) {
        logicLink = new BusinessLinkedList<>(linkName);
        for (ILogicHandler<T, D, R> logicHandler: logicHandlers){
            logicLink.add(logicHandler);
        }
    }

    public BusinessLinkedList<T, D, R> getLogicLink() {
        return logicLink;
    }

}

