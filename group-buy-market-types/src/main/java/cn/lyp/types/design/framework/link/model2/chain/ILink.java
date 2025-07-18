package cn.lyp.types.design.framework.link.model2.chain;

/**
 * @Author: LypCoding
 * @Date: 2025/7/17 16:10
 * @Description:
 */
public interface ILink<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();

}
