package cn.vgbhfive.graduationproject.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * 邮件操作工具类
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Component
public class EmailUtils {

    private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);

    @Autowired
    private static JavaMailSender javaMailSender; //null

    @Value("${spring.mail.username}")
    private static String from;

    /**
     * 发送普通邮件
     * @param to
     * @param subject
     * @param content
     * @return
     */
    public static Boolean sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(content);

        try {
            javaMailSender.send(mail);
            logger.info("Send Simple Mail Successful!");
            return true;
        } catch (Exception e) {
            logger.info("Send Simple Mail Error! " + e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 发送具有链接地址的邮件
     * @param to
     * @param subject
     * @param context
     * @return
     */
    public static Boolean sendHtmlMail(String to, String subject, String context) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context, true);

            javaMailSender.send(message);
            logger.info("Send Simple Mail Successful!");
            return true;
        } catch (Exception e) {
            logger.info("Send MiME Mail Error! "+ e);
            return false;
        }
    }


}
