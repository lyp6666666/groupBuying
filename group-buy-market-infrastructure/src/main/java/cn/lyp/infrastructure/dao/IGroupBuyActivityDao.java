package cn.lyp.infrastructure.dao;

import cn.lyp.infrastructure.dao.po.GroupBuyActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: LypCoding
 * @Date: 2025/7/2 18:41
 * @Description: 活动拼团Dao
 */
@Mapper
public interface IGroupBuyActivityDao {

    List<GroupBuyActivity> queryGroupBuyActivityList();

    GroupBuyActivity queryValidGroupBuyActivity(GroupBuyActivity groupBuyActivity);
}
