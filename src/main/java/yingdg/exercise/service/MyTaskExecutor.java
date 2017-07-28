package yingdg.exercise.service;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/7/28.
 */
@Service
public class MyTaskExecutor {
    @Resource
    private TaskExecutor executor;
    private int num = 2;

    public void myExecute() {
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        /*
        1, taskExecutor.execute(); 激活的线程都是守护线程，主线程结束，守护线程就会放弃执行，
        这个在业务中式符合逻辑的，在单元测试中为了看到执行效果，需要自行阻塞主线程。

        2, taskExecutor.execute(); 的执行也不是完全安全的，
        在执行的过程中可能会因为需要的线程查过了线程队列的容量而抛出运行时异常，如有必要需要捕获。
         */
    }

    // 异步任务1
    @Async
    public void myAsyn() {
        System.out.println("num: " + (++num));
    }

    // 异步任务2
    @Async
    public void myAsyn2() {
        System.out.println("numX2:" + num*2);
    }
}
