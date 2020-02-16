package kasei.spring.binding.bean.validate;


import kasei.spring.binding.validator.MyConstraintValidatorAnno;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Component
@Validated // 表明 spring 需要对当前类进行校验
public class Person {

    @NotNull
    @Size(max=6)
    @MyConstraintValidatorAnno
    @Value("kasei haku")
    private String name;

    @Min(0)
    @Max(100)
    @Value("3")
    private int age;
}
