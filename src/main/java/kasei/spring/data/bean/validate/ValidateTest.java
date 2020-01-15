package kasei.spring.data.bean.validate;

import kasei.spring.data.validator.MyConstraintValidatorAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Component
@Validated // 表明 spring 需要对当前类进行校验
public class ValidateTest {

    @MyConstraintValidatorAnno
    // @NotNull(message = "空")
    public String getPerson() {
        // return null;
        return "qwer  asdf";
    }

}
