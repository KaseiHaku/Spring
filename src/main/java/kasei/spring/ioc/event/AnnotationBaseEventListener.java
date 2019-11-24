package kasei.spring.ioc.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBaseEventListener {

    @EventListener({ContextRefreshedEvent.class})
    @Order(1)
    public void refreshEventHandler(ApplicationEvent event){
        System.out.println("context refresh");
    }

    @EventListener({ContextStartedEvent.class})
    public void startEventHandler(ApplicationEvent event){
        System.out.println("context start");
    }

    @EventListener({ContextStoppedEvent.class})
    public void stopEventHandler(ApplicationEvent event){
        System.out.println("context stop");
    }

    @EventListener({ContextClosedEvent.class})
    public void closeEventHandler(ApplicationEvent event){
        System.out.println("context close");
    }

    /** todo Web 中使用

    @EventListener({RequestHandledEvent.class})
    public void requestEventHandler(){
        System.out.println("context request");
    }

    @EventListener({ServletRequestHandledEvent.class})
    public void servletRequestEventHandler(){
        System.out.println("context servlet request");
    }*/

}
