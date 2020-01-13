package kasei.spring.data.validate.single;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Data
@Component
public class Person {


    @Value("single validate demo")
    private String name;

    @Value("-12")
    private Integer age;
}
