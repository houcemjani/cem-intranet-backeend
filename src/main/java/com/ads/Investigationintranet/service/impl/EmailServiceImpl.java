package com.ads.Investigationintranet.service.impl;


import com.ads.Investigationintranet.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

  @Autowired
  public JavaMailSender emailSender;

  @Autowired
  private Environment env;


  @Async
  public void sendSimpleMessage(String to,String subject,String text) {
    try {
      MimeMessage message=emailSender.createMimeMessage();
      MimeMessageHelper helper=new MimeMessageHelper(message,true);
      String mailFrom=env.getProperty("spring.mail.username");
      if(mailFrom != null && mailFrom.length() > 0) {
        helper.setFrom(mailFrom);
      }
      helper.setText(text,true);
      helper.setTo(to);
      helper.setSubject(subject);
      log.info("-------------------------------------------- SENT EMAIL  -----------------------------------------------------");
      log.info("> Receiver : " + to);
      log.info("> Sender : " + mailFrom);
      log.info("> Subject : " + subject);
      log.info("> Template : " + text);
      log.info("--------------------------------------------------------------------------------------------------------------");
      emailSender.send(message);
    } catch(MessagingException e) {
      log.error("Exception while sending simple message {}",e.getMessage());
      throw new RuntimeException(e);
    }
  }

}