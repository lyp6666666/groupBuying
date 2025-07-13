package cn.lyp.infrastructure.dcc;

import cn.lyp.types.annotations.DCCValue;
import org.springframework.stereotype.Service;

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

}
