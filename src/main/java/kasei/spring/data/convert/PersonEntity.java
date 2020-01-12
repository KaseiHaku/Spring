package kasei.spring.data.convert;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonEntity {
    @Value("010-12345")
    private Telephone telephone;
}
