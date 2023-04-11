package com.ads.Investigationintranet.service.impl;


import com.ads.Investigationintranet.exception.UserNotFoundException;
import com.ads.Investigationintranet.repository.UserRepository;
import com.ads.Investigationintranet.service.EmailService;
import com.ads.Investigationintranet.service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailingServiceImpl implements MailingService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EmailService emailService;

  @Override
  public ResponseEntity<String> sendEmails(List<String> emailList) throws UserNotFoundException {
    for (String email : emailList) {
//      User user = userRepository.findUserByEmail(email);
//      if (user == null) {
//        throw new UserNotFoundException("No user found with email: " + email);
//      }

      String subject = "BOUTIQUE DE SPORT | Renouvellement Mot De Passe";
      String message = "Bonjour, <b> </b>"+ " Si marwan <br/><br/>" +
          "Cordialement, <br>" +
          "Équipe Quodup.";

      emailService.sendSimpleMessage(email, subject, message);

    }
    return ResponseEntity.ok("Emails sent successfully.");
  }
}
