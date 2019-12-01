package kasei.spring.ioc.extension.i18n;

import org.springframework.context.HierarchicalMessageSource;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/** todo spring 支持 i18n 字符的接口
 * 1. 该 bean name 必须是 messageSource
 * 2. 当前容器找不到，去富容器找 同名的 bean
 * 3. 父容器也找不到，自动创建一个 {@lik org.springframework.context.DelegatingMessageSource} 实例，并使用
 * */
// @Component("messageSource")  // 注释掉，防止使用
public class CustomMessageSource implements HierarchicalMessageSource {
    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return null;
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return null;
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return null;
    }

    @Override
    public void setParentMessageSource(MessageSource parent) {

    }

    @Override
    public MessageSource getParentMessageSource() {
        return null;
    }
}
