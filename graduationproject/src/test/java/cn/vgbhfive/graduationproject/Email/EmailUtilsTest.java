package cn.vgbhfive.graduationproject.Email;

import cn.vgbhfive.graduationproject.utils.EmailUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @time: 2019/03/21
 * @author: Vgbh
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailUtilsTest {

    @Autowired
    private EmailUtils emailUtils;

    @Test
    public void testSimpleEmail() {
        emailUtils.sendSimpleMail("3408835536@qq.com", "test email", "Test Email!");
    }

    @Test
    public void testHtmlEmail() {
        String content = "Test Email!" +
                "<Html> <body> <a href='www.baidu.com'> baidu </a> </body> <Html>";
        emailUtils.sendHtmlMail("3408835536@qq.com", "test email", content);
    }
}
