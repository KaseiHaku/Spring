package kasei.spring.data.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** TODO 一个自定义个校验器注解 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {MyConstraintValidator.class})
public @interface MyConstraintValidatorAnno {
    String message() default "字符串不能包含空白符";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}