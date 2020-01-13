package kasei.spring.data.convert.converter;

import org.springframework.core.convert.converter.Converter;

public class String2ColorConverter implements Converter<String, Color> {
    @Override
    public Color convert(String source) {
        return Color.valueOf(source);
    }
}
