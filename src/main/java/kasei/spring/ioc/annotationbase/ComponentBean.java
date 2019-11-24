package kasei.spring.ioc.annotationbase;

import kasei.spring.ioc.AnnotationBase;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("customNamedComponentBean")
@Scope("singleton")
public class ComponentBean implements AnnotationBase {


    private String name = "ComponentBean";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
