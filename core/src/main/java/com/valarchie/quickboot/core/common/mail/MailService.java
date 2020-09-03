package com.valarchie.quickboot.core.common.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
* description:
* @author: valarchie
* on: 2020/7/30
* @email: 343928303@qq.com
*/
@Service
@Slf4j
public class MailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    /**
     * 发送简单邮件
     * @param receiver 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMessage(String receiver, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mailSender.getUsername());
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
        } catch (Exception e) {
            log.error("fail to send simple message", e);
        }
    }

    /**
     * 发送HTML邮件
     * @param receiver 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMessage(String receiver, String subject, String content) {

        try {

            MimeMessageHelper mimeMessageHelper = getMimeMessageHelper(receiver, subject, content);
            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (Exception e) {
            log.error("fail to send MIME message！", e);
        }

    }

    /**
     * 发送带附件的邮件
     *
     * @param receiver 收件人
     * @param subject  主题
     * @param content  内容
     * @param filePath 附件路径
     */
    public void sendMimeMessageWithAttachment(String receiver, String subject, String content, String filePath) {

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper mimeMessageHelper = getMimeMessageHelper(receiver, subject, content);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = file.getFilename();

            mimeMessageHelper.addAttachment(fileName, file);
            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (Exception e) {
            log.error("fail to send MIME message！", e);
        }
    }

    /**
     * 发送带静态文件的邮件
     *
     * @param receiver 收件人
     * @param subject  主题
     * @param content  内容
     * @param resourceMap 需要替换的静态文件
     */
    public void sendMimeMessageWithRichMedia(String receiver, String subject, String content, Map<String, String> resourceMap) {

        try {

            MimeMessageHelper mimeMessageHelper = getMimeMessageHelper(receiver, subject, content);

            for (Map.Entry<String, String> entry : resourceMap.entrySet()) {
                FileSystemResource file = new FileSystemResource(new File(entry.getValue()));
                mimeMessageHelper.addInline(entry.getKey(), file);
            }

            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (Exception e) {
            log.error("fail to send MIME message！", e);
        }
    }


    /**
     * 生成富文本信息工具类
     * @param receiver 收件人
     * @param subject 主题
     * @param content 内容
     * @return 返回 富文本信息工具类
     */
    private MimeMessageHelper getMimeMessageHelper(String receiver, String subject, String content) {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = null;

        try {

            helper = new MimeMessageHelper(message, true);
            //true表示需要创建一个multipart message
            helper.setFrom(mailSender.getUsername());
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content, true);
        } catch (Exception e) {
            log.error("fail to create MIME message, receiver is {}, subject is {}, content is {}", receiver, subject,
                    content);
        }

        return helper;

    }


}