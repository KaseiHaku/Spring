package kasei.spring.data.validate.single;

import kasei.spring.data.validate.single.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");

        Person person = (Person) target;
        if (person.getAge() < 0) {
            errors.reject("age", "negative value");
        } else if (person.getAge() > 110) {
            errors.rejectValue("age", "too old");
        }

    }
}
