package kasei.spring.binding.bean.validate;

import kasei.spring.binding.validator.MyConstraintValidatorAnno;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated // 表明 spring 需要对当前类进行校验
public class ValidateTest {

    @MyConstraintValidatorAnno
    // @NotNull(message = "空")
    public String getPerson() {
        // return null;
        return "qwerasdf";
        // return "qwer  asdf";  // 测试自定义校验器
    }

}
