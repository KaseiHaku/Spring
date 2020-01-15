package kasei.spring.data.bean.convert;

import lombok.Data;

@Data
public class Color {
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    private int currentVal = RED;


}
