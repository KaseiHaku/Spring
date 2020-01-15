package kasei.spring.data.bean.convert;

import kasei.spring.data.bean.convert.Telephone;
import kasei.spring.data.converter.BigDecimalFormatterAnno;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class ConverterTest {

    // 使用 @Component 将当前类注入到 IOC 容器中时，@Value 中的 String 类型值，会自动调用 String -> Telephone 类型的转换器
    @Value("010-12345")
    private Telephone telephone;

    @Value("GREEN")
    private Color color;

    @BigDecimalFormatterAnno
    @Value("DB12.3456")
    private BigDecimal bigDecimal;

    // @BigDecimalFormatterAnno
    // private Integer integer;
}
