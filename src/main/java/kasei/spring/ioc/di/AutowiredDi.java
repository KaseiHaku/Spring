package kasei.spring.ioc.di;

import kasei.spring.ioc.AnnotationBase;
import kasei.spring.ioc.annotationbase.ControllerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AutowiredDi {
    private String name = "QualifierDi";


    private ControllerBean controllerBean;
    private Set<AnnotationBase> annotationBaseSet;



    public Set<AnnotationBase> getAnnotationBaseSet() {
        return annotationBaseSet;
    }

    @Autowired
    public void setAnnotationBaseSet(Set<AnnotationBase> annotationBaseSet) {
        this.annotationBaseSet = annotationBaseSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ControllerBean getControllerBean() {
        return controllerBean;
    }

    @Autowired
    public void setControllerBean(ControllerBean controllerBean) {
        this.controllerBean = controllerBean;
    }
}
