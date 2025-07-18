package cn.lyp.types.design.framework.link.model2.chain;

import cn.lyp.types.design.framework.link.model2.handler.ILogicHandler;

/**
 * @Author: LypCoding
 * @Date: 2025/7/17 16:11
 * @Description:
 */
public class BusinessLinkedList<T, D, R> extends LinkedList<ILogicHandler<T, D, R>> implements ILogicHandler<T, D, R> {

    public BusinessLinkedList(String name) {
        super(name);
    }

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        Node<ILogicHandler<T, D, R>> current = this.first;
        do {
            ILogicHandler<T, D, R> item = current.item;
            R apply = item.apply(requestParameter, dynamicContext);
            if (null != apply) return apply;

            current = current.next;
        } while (null != current);

        return null;
    }

}


