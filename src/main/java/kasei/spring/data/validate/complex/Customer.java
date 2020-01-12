package kasei.spring.data.validate.complex;

import lombok.Data;

@Data
public class Customer {

    private String firstName;
    private String lastName;
    private Address address;

}
