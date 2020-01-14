package kasei.spring.data.bean.convert;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Telephone {

    private String areaCode;
    private String phoneNumber;

    @Override
    public String toString() {
        return this.areaCode + "-" + this.phoneNumber;
    }
}
