package cn.lyp.test.infrastructure.dao;

import cn.lyp.infrastructure.dao.IGroupBuyDiscountDao;
import cn.lyp.infrastructure.dao.po.GroupBuyActivity;
import cn.lyp.infrastructure.dao.po.GroupBuyDiscount;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LypCoding
 * @Date: 2025/7/2 19:27
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupBuyDiscountDaoTest {

    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;

    @Test
    public void test(){

        List<GroupBuyDiscount> groupBuyActivityList = groupBuyDiscountDao.queryGroupBuyDiscountList();
        log.info("测试结果：{}", JSON.toJSONString(groupBuyActivityList));

    }

}
