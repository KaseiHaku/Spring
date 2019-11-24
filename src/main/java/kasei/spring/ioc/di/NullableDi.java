package kasei.spring.ioc.di;

import kasei.spring.ioc.NullBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NullableDi {


    private String name = "NullableDi";


    private NullBase nullableBean;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NullBase getNullableBean() {
        return nullableBean;
    }

    @Autowired
    public void setNullableBean(@Nullable NullBase nullableBean) {
        if(nullableBean != null){
            this.nullableBean = nullableBean;
        }
    }


}
