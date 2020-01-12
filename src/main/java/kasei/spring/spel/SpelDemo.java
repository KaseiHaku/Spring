package kasei.spring.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpelDemo {


    public void run(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
    }

    public void run1(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
    }
    public void run2(){
        ExpressionParser parser = new SpelExpressionParser();

        // invokes 'getBytes()'
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
    }
    public void run3(){}
    public void run4(){}
    public void run5(){}
    public void run6(){}
}
