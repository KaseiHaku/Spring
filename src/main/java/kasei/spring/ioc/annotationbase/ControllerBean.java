package kasei.spring.ioc.annotationbase;

import kasei.spring.ioc.AnnotationBase;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

@Controller
@Primary
public class ControllerBean implements AnnotationBase {
    private String name = "ControllerBean";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
