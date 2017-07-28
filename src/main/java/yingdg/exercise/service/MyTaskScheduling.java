package yingdg.exercise.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by yingdg on 2017/7/28.
 */
@Service
public class MyTaskScheduling {

    @Scheduled(fixedRate = 2000)
    public void printInfo() {
        System.out.println("定时任务" + new Date());
    }

}
