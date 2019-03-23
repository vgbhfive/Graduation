package cn.vgbhfive.graduationproject.Email;

import cn.vgbhfive.graduationproject.utils.EmailUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @time: 2019/03/21
 * @author: Vgbh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailUtilsTest {

    @Test
    public void testSimpleEmail() {
        EmailUtils.sendSimpleMail("570622675@qq.com", "test email", "Test Email!");
    }

    @Test
    public void testHtmlEmail() {
        String content = "Test Email!" +
                "<Html> <body> <a href='www.baidu.com'> baidu </a> </body> <Html>";
        EmailUtils.sendHtmlMail("570622675@qq.com", "test email", content);
    }
}
