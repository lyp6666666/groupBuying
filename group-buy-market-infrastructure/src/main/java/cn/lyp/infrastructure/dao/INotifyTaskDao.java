package cn.lyp.infrastructure.dao;

import cn.lyp.infrastructure.dao.po.NotifyTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: LypCoding
 * @Date: 2025/7/22 0:09
 * @Description:
 */
@Mapper
public interface INotifyTaskDao {

    void insert(NotifyTask notifyTask);

}
