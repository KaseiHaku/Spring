package kasei.spring.data.bean.validate;

import lombok.Data;

@Data
public class Customer {

    private String firstName;
    private String lastName;
    private Address address;

}
