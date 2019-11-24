package kasei.spring.ioc.di;

import kasei.spring.ioc.AnnotationBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QualifierDi {


    private String name = "QualifierDi";

    @Autowired
    @Qualifier("categoryBean") // qualifier 如果用在 泛型字段上，那么会自动取泛型为 限定符
    private Map<String, AnnotationBase> annotationBaseMap;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, AnnotationBase> getAnnotationBaseMap() {
        return annotationBaseMap;
    }

    public void setAnnotationBaseMap(Map<String, AnnotationBase> annotationBaseMap) {
        this.annotationBaseMap = annotationBaseMap;
    }
}
