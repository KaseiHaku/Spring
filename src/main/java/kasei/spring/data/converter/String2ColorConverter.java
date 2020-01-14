package kasei.spring.data.converter;

import kasei.spring.data.bean.validate.Color;
import org.springframework.core.convert.converter.Converter;

public class String2ColorConverter implements Converter<String, Color> {
    @Override
    public Color convert(String source) {
        return Color.valueOf(source);
    }
}
