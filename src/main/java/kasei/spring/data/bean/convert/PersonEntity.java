package kasei.spring.data.bean.convert;

import kasei.spring.data.bean.convert.Telephone;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonEntity {
    @Value("010-12345")
    private Telephone telephone;
}
