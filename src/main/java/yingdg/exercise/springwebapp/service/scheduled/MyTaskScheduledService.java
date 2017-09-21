package yingdg.exercise.springwebapp.service.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yingdg on 2017/7/28.
 */
@Service
public class MyTaskScheduledService {
    private AtomicInteger i = new AtomicInteger();

    @Scheduled(fixedRate = 1800000)
    public void printInfo() {
        int increment = i.getAndIncrement();
        System.out.println("定时任务" + increment + ": " + new Date());
    }

}
