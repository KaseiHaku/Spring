package kasei.spring.event;

import com.skeyedu.advisory.task.TextThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshEventHandler implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println("hhhgggttt");
        if(contextRefreshedEvent.getApplicationContext().getParent() == null ){
            //root application context 没有parent，他就是老大.
        }
    }
}
