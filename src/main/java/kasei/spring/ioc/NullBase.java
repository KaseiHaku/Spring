package kasei.spring.ioc;

import org.springframework.stereotype.Component;

@Component
public interface NullBase {
    public static String name = "NullBase";
    public String getName(String name) ;
}
