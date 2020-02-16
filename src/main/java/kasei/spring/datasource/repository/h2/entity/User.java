package kasei.spring.datasource.repository.h2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class User {

    private Integer id;
    private String account;
    private String password;

}
