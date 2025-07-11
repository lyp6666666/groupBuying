package cn.lyp.infrastructure.dao;

import cn.lyp.infrastructure.dao.po.SCSkuActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: LypCoding
 * @Date: 2025/7/7 11:40
 * @Description:
 */
@Mapper
public interface ISCSkuActivityDao {

    SCSkuActivity querySCSkuActivityBySCGoodsId(SCSkuActivity scSkuActivity);

}
