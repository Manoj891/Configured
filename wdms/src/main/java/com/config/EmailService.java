package com.config;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

    String sender = "", passwprd = "";
    String message = "Sent";
    boolean status;

    public boolean sendmail(String receiver, String subject, String body) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        sender = "infowebnpl@gmail.com";
        passwprd = "web@manoj554";

        try {
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sender, passwprd);
                }
            });

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(sender, false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
            msg.setSubject(subject);
            msg.setContent(body, "text/html");
            msg.setSentDate(new Date());
            Transport.send(msg);
            status = true;
        } catch (Exception e) {
            message = e.getMessage();
            status = false;
        }
        return status;
    }

    public String getMsg() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

}
