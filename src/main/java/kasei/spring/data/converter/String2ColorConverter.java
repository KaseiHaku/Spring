package kasei.spring.data.converter;

import kasei.spring.data.bean.convert.Color;
import org.springframework.core.convert.converter.Converter;

public class String2ColorConverter implements Converter<String, Color> {
    @Override
    public Color convert(String source) {
        Color color = new Color();
        switch (source) {
            case "RED": color.setCurrentVal(0); break;
            case "GREEN": color.setCurrentVal(1); break;
            case "BLUE": color.setCurrentVal(2); break;
        }

        return color;
    }
}
