package kasei.spring.data.converter;


import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.math.BigDecimal;
import java.util.Set;

/** TODO 用于绑定注解和实际的 Formatter 逻辑实现类 */
public class BigDecimalFormatterAnnotationFactory implements AnnotationFormatterFactory<BigDecimalFormatterAnno> {

    private static final BigDecimalFormatter BIG_DECIMAL_FORMATTER = new BigDecimalFormatter();

    @Override
    public Set<Class<?>> getFieldTypes() {
        return Set.of(BigDecimal.class);
    }

    @Override
    public Printer<?> getPrinter(BigDecimalFormatterAnno annotation, Class<?> fieldType) {
        return BIG_DECIMAL_FORMATTER;
    }

    @Override
    public Parser<?> getParser(BigDecimalFormatterAnno annotation, Class<?> fieldType) {
        return BIG_DECIMAL_FORMATTER;
    }
}
