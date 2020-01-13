package kasei.spring.data.validate.spring;

import kasei.spring.data.validate.spring.MyConstraintValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy={ MyConstraintValidator.class })
public @interface MyConstraint {


}