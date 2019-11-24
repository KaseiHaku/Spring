package kasei.spring.ioc.annotationbase;

import kasei.spring.ioc.AnnotationBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("categoryBean")
public class ServiceBean implements AnnotationBase {
    private String name = "ServiceBean";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
