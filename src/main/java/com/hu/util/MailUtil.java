package com.hu.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class MailUtil {

    public static boolean send(Mail mail) {

        // TODO
        /**
         * from:实际发送邮件的邮箱
         * port:对应的邮件服务器的端口地址
         * host:对应的邮件服务器的地址
         * pass:授权码
         * nickname:
         */
        String from = "17621075787@163.com";
        int port = 25;
        String host = "smtp.163.com";
        String pass = "hzq147258";
        String nickname = "arui";

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(host);
            email.setCharset("UTF-8");
            for (String str : mail.getReceivers()) {
                email.addTo(str);
            }
            email.setFrom(from, nickname);
            //email.setSmtpPort(port);
            email.setAuthentication(from, pass);
            email.setSubject(mail.getSubject());
            email.setMsg(mail.getMessage());
            email.send();
            log.info("{} 发送邮件到 {}", from, StringUtils.join(mail.getReceivers(), ","));
            return true;
        } catch (EmailException e) {
            log.error(from + "发送邮件到" + StringUtils.join(mail.getReceivers(), ",") + "失败", e);
            return false;
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("894100379@qq.com");
        Mail mail = Mail.builder().message("").subject("").receivers(set).build();
        boolean flag = MailUtil.send(mail);
        if(flag){
            System.out.println("发送成功");
        }else{
            System.out.println("发送失败");
        }
    }

}

