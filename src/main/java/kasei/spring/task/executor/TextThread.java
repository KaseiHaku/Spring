package kasei.spring.task.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TextThread {

    @Async
    public void test(){
        int i =0 ;
        while (true) {
            System.out.println("测试1："+i++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Async
    public void test2(){
        int i =0 ;
        while (true) {
            System.out.println("发送：" + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
