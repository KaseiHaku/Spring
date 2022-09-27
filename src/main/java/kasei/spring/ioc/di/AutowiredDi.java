package kasei.spring.ioc.di;

import kasei.spring.ioc.AnnotationBase;
import kasei.spring.ioc.annotationbase.ControllerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Spring DI 方式:
 *      基于构造函数注入:
 *          基要求具有唯一的 构造函数 或者 静态工厂方法
 *      基于 setter 方法注入:
 *          要求具有 setter 方法
 *      基于 field 字段反射注入: @Deprecated 
 *          在字段上使用 @Autowired 注解
 *          
 * */
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
