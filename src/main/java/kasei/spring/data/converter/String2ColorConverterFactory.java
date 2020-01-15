package kasei.spring.data.converter;

import kasei.spring.data.bean.convert.Color;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/** TODO 集中式的管理所有 Converter */
public class String2ColorConverterFactory implements ConverterFactory<String, Color> {
    @Override
    public <T extends Color> Converter<String, T> getConverter(Class<T> targetType) {
        return null;
    }

    private final class Str2ColorConverter<T extends Color> implements Converter<String, T>{

        private Class<T> colorType;

        public Str2ColorConverter(Class<T> colorType) {
            this.colorType = colorType;
        }

        @Override
        public T convert(String source) {
            // Color c = Color.valueOf(this.colorType, source);
            return null;
        }
    }
}
