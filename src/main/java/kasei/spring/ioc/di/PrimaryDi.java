package kasei.spring.ioc.di;

import kasei.spring.ioc.AnnotationBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrimaryDi {


    private String name = "PrimaryDi";


    private AnnotationBase annotationBase;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnnotationBase getAnnotationBase() {
        return annotationBase;
    }

    @Autowired
    public void setAnnotationBase(AnnotationBase annotationBase) {
        this.annotationBase = annotationBase;
    }
}
