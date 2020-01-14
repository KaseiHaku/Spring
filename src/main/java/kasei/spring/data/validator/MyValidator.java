package kasei.spring.data.validator;


import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** TODO @MyConstraint validate.txt 注解对应的校验器，逻辑实现类 */
public class MyValidator implements ConstraintValidator<MyValidatorAnno, String> {


    private String valueInAnnotation;

    @Override
    public void initialize(MyValidatorAnno constraintAnnotation) {
        this.valueInAnnotation = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String valueBeAnnotated, ConstraintValidatorContext context) {
        return StringUtils.containsAny(valueBeAnnotated, " ");
    }


}
