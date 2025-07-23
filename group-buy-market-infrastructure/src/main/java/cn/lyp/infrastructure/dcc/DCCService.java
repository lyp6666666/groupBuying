package cn.lyp.infrastructure.dcc;

import cn.lyp.types.annotations.DCCValue;
import cn.lyp.types.common.Constants;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: LypCoding
 * @Date: 2025/7/13 13:02
 * @Description:
 */
@Service
public class DCCService {

    @DCCValue("downgradeSwitch:0")
    private String downgradeSwitch;

    @DCCValue("cutRange:100")
    private String cutRange;

    @DCCValue("scBlacklist:s02c02")
    private String scBlacklist;

    public boolean isDowngradeSwitch(){
        return "1".equals(downgradeSwitch);
    }

    public boolean isCutRange(String userId){
        int hashCode = Math.abs(userId.hashCode());

        int lastTwoDigits =  hashCode % 100;

        if(lastTwoDigits <= Integer.parseInt(cutRange)){
            return true;
        }
        return false;
    }

    /**
     * 判断黑名单拦截渠道，true 拦截、false 放行
     */
    public boolean isSCBlackIntercept(String source, String channel) {
        List<String> list = Arrays.asList(scBlacklist.split(Constants.SPLIT));
        return list.contains(source + channel);
    }
}
