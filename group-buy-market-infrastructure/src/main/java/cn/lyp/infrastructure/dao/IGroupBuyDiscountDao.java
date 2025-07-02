package cn.lyp.infrastructure.dao;

import cn.lyp.infrastructure.dao.po.GroupBuyDiscount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: LypCoding
 * @Date: 2025/7/2 18:42
 * @Description: 折扣Dao层对象
 */
@Mapper
public interface IGroupBuyDiscountDao {

    List<GroupBuyDiscount> queryGroupBuyDiscountList();
}
