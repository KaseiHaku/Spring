package kasei.spring.ioc.annotationbase;

import kasei.spring.ioc.AnnotationBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("categoryBean")
public class RepositoryBean implements AnnotationBase {
    private String name = "RepositoryBean";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}