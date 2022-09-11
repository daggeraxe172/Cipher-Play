package Cryptography;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRYPTOGMAIL {
    public static void sendMail(String to,String mail, String pass, String usersubject,String usermessage) throws MessagingException{
        System.out.println("Initiated...");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String from = mail;
        String password = pass;

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        Message message = prepareMessage(session, from, to, usersubject, usermessage);

        Transport.send(message);

        System.out.println("Sent.");
    }


    private static Message prepareMessage(Session session,String from,String to,String sub, String mes){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(mes);
            System.out.println("Sending...");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(CRYPTOGMAIL.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

}