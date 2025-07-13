package cn.lyp.api;

import cn.lyp.api.response.Response;

/**
 * @Author: LypCoding
 * @Date: 2025/7/13 14:43
 * @Description:
 */
public interface IDCCService {

    Response<Boolean> updateConfig(String key,String value);


}
