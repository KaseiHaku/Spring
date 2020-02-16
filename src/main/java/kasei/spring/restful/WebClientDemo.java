package kasei.spring.restful;


import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class WebClientDemo {

    public void demo(){
        WebClient webClient = WebClient.builder().baseUrl("https://www.baidu.com").build();
        webClient.get().exchange();
    }

}
