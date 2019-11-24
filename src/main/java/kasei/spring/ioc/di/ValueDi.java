package kasei.spring.ioc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueDi {

    private String name = "ValueDi";
    private String configFileValue;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfigFileValue() {
        return configFileValue;
    }

    @Autowired
    public void setConfigFileValue(@Value("${mysql.user2:defaultValue}") String configFileValue) {
        this.configFileValue = configFileValue;
    }
}
