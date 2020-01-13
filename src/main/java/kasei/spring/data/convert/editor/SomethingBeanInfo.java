package kasei.spring.data.convert.editor;

import org.springframework.beans.propertyeditors.CustomNumberEditor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.SimpleBeanInfo;

/**
 * 因为该类符合 JavaBean 规范，所以该类中存在的 PropertyEditor 会被注册到 Spring 中
 * */
public class SomethingBeanInfo extends SimpleBeanInfo {

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            final PropertyEditor numberPE = new CustomNumberEditor(Integer.class, true);
            PropertyDescriptor ageDescriptor = new PropertyDescriptor("age", Something.class) {
                public PropertyEditor createPropertyEditor(Object bean) {
                    return numberPE;
                }
            };
            return new PropertyDescriptor[]{ageDescriptor};
        } catch (IntrospectionException ex) {
            throw new Error(ex.toString());
        }
    }
}