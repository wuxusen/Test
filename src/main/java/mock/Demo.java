package mock;

import java.util.Date;

public class Demo {


    private Long currentTimestamp;

    private Long dueTime;

    public Demo(Long currentTimestamp,Long dueTime){
        this.currentTimestamp = currentTimestamp;
        this.dueTime = dueTime;
    }


    public long caculateDelayDays(Date dueTime) {

        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / 86400;

        return delayDays;

    }




}