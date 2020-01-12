package kasei.spring.data.validate.complex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddressValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "country", "Empty");
        ValidationUtils.rejectIfEmpty(errors, "province", "Empty");
        ValidationUtils.rejectIfEmpty(errors, "city", "Empty");
    }
}
