package kasei.spring.binding.converter;

import org.springframework.format.Formatter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

public class BigDecimalFormatter implements Formatter<BigDecimal> {

    @Override
    public BigDecimal parse(String text, Locale locale) throws ParseException {
        return new BigDecimal(text.substring(2));
    }

    @Override
    public String print(BigDecimal object, Locale locale) {
        return "BD" + object.toPlainString();
    }
}
