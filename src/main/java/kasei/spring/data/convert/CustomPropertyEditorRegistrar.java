package kasei.spring.data.convert;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public final class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    public void registerCustomEditors(PropertyEditorRegistry registry) {


        // registry.registerCustomEditor(ExoticType.class, new ExoticTypeEditor());


    }
}