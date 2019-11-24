package kasei.spring.ioc.javabase;


import kasei.spring.ioc.JavaBase;

public class JavaBaseBean implements JavaBase {

    private String name = "JavaBaseBean";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
