package com.ads.Investigationintranet.domain;//package com.ads.Investigationintranet.domain;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.List;
//
//@Component
//public class EmailMessage {
//    @Autowired
//    private JavaMailSender emailSender;
//
//    private String MESSAGE_PART_1 = "Bonjour,\n" +
//            "\nNous avons reçu une demande de réinitialisation du mot de passe pour votre compte Innogec.\n" +
//            "\nSaisissez ce code pour terminer la réinitialisation.\n\n ";
//
//    private String MESSAGE_PART_3 = " \n\nMerci de nous aider à préserver la sécurité de votre compte.\n" +
//            "\nL’équipe Innohealth";
//
//    private String PASSWORD_MESSAGE = "Bonjour, \nS'il vous plait, utilisez le mot de passe suivant pour se connecter\n" +
//            "Mot de passe : ";
//
//    private String INNOHEALTH_MESSAGE = "\nL’équipe Innohealth";
//
//
//    public void constructResetTokenEmail(String userEmail, String token) throws MessagingException {
//        String message = MESSAGE_PART_1 + token + MESSAGE_PART_3;
//        this.constructEmailAndSend("token@innohealth.fr", "\n" + "Réinitialiser le mot de passe", message + " \r\n", userEmail);
//    }
//
//    public void sendPasswordEmail(String userName, char[] newPassword1) throws MessagingException {
//        String message = PASSWORD_MESSAGE + String.valueOf(newPassword1) + INNOHEALTH_MESSAGE;
//        this.constructEmailAndSend("token@innohealth.fr", "\n" + "Login Innogec", message + " \r\n", userName);
//
//    }
//
//    public void constructEmailAndSend(String from, String subject, String body, String to) throws MessagingException {
//        MimeMessage email = emailSender.createMimeMessage();
//        email.setSubject(subject, "UTF-8");
//        email.setText(body, "UTF-8");
//        email.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
//        email.addFrom(new InternetAddress[]{new InternetAddress(from)});
//        emailSender.send(email);
//    }
//
//    public void constructEmailAndSend(String from, String subject, String body, String to, List<String> cc) throws MessagingException {
//        MimeMessage email = emailSender.createMimeMessage();
//        email.setSubject(subject, "UTF-8");
//        email.setText(body, "UTF-8");
//        email.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
//        email.addFrom(new InternetAddress[]{new InternetAddress(from)});
//        cc.forEach(mail -> {
//            try {
//                email.addRecipient(MimeMessage.RecipientType.CC, new InternetAddress(mail));
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//        });
//        emailSender.send(email);
//    }
//}
//
