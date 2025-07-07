package cn.lyp.domain.activity.service.trial.thread;

import cn.lyp.domain.activity.adapter.repository.IActivityRepository;
import cn.lyp.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * @Author: LypCoding
 * @Date: 2025/7/7 13:52
 * @Description:
 */
public class QueryGroupActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    private final String source;

    private final String chanel;

    private final IActivityRepository repository;


    public QueryGroupActivityDiscountVOThreadTask(String source, String chanel, IActivityRepository repository){
        this.source = source;
        this.chanel = chanel;
        this.repository = repository;
    }


    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        return repository.queryGroupBuyActivityDiscountVO(source,chanel);
    }
}
