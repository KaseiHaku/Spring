package kasei.spring.mail;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class SpringMail {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SimpleMailMessage templateMailMessage;
    @Autowired
    private Configuration freeMakerConfiguration;

    final private String fromAddress = "3*******@qq.com";
    final private String toAddress = "1939123683@qq.com";

    public void sendMail(){
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMailMessage); // 从模板中复制默认配置
        msg.setTo(toAddress);
        msg.setText("test content");

        try {
            this.javaMailSender.send(msg);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }


    public void sendMimeMail(){
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            /** 配置收件人 */
            Address[] addresses = new Address[]{new InternetAddress(toAddress)};
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, addresses);
            /** 配置抄送人 */
            Address[] copyToAddresses = new Address[]{new InternetAddress(toAddress)};
            mimeMessage.setRecipients(MimeMessage.RecipientType.CC, copyToAddresses);
            /** 配置密送人 */
            Address[] secretToAddresses = new Address[]{new InternetAddress(toAddress)};
            mimeMessage.setRecipients(MimeMessage.RecipientType.BCC, secretToAddresses);
            /** 配置邮件标题 */
            mimeMessage.setSubject("邮件标题");
            /** 配置邮件正文 */
            mimeMessage.setContent("邮件正文", "text/html;charset=UTF-8");

        };

        try {
            this.javaMailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    /** TODO 使用 MimeMessageHelper 来方便的生成 MimeMessage */
    public void sendMailWithMimeMessageHelper(){
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true); // true 表示带附件
            helper.setFrom(new InternetAddress(fromAddress));
            helper.addTo(new InternetAddress(toAddress));
            helper.setSubject("Spring Mail Test");

            // 添加附件
            FileSystemResource file = new FileSystemResource("./src/main/resources/img/haku.jpg");
            helper.addAttachment("alias.jpg", file);


            // 构建 freemaker data model
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("user", "KSF");

            // 引入 freemaker 模板
            Template template = freeMakerConfiguration.getTemplate("HelloWorld.ftl");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, dataModel); // 进行模板和 DataModel 的绑定

            // 添加行内文件
            // use the true flag to indicate the text included is HTML
            helper.setText(text, true);
            FileSystemResource res = new FileSystemResource(new File("./src/main/resources/img/haku.jpg"));
            helper.addInline("identifier1234", res); // 添加行内文件需要使用 Content-ID 来绑定

        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

        this.javaMailSender.send(mimeMessage);
    }
}
