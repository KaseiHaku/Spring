package kasei.spring.ioc.config;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.security.GeneralSecurityException;
import java.util.Properties;

@Configuration
public class MailConfig {

    private final String fromAddress = "37******@qq.com";
    private final String mailServer = "smtp.qq.com";  // QQ 邮件服务器
    private final String AuthorizationCode = "dynerrtrsdueubjge"; // QQ 邮箱授权码

    @Bean
    public JavaMailSender javaMailSender() throws GeneralSecurityException {

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); // 设置邮件协议
        props.setProperty("mail.smtp.host", mailServer); // 设置系统邮件发送服务器
        props.setProperty("mail.smtp.auth", "true"); // 设置是否需要身份验证

        /** 如果邮件服务器需要 SSL 连接，则需要以下代码 */
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                PasswordAuthentication passwordAuthentication = new PasswordAuthentication(fromAddress, AuthorizationCode); // 发送邮箱地址 和 授权码（不是密码）
                return passwordAuthentication;
            }
        });
        session.setDebug(true);


        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setSession(session);
        return javaMailSender;
    }

    @Bean
    public SimpleMailMessage templateMailMessage(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromAddress);
        simpleMailMessage.setSubject("Spring Mail Test");
        return simpleMailMessage;
    }


}
