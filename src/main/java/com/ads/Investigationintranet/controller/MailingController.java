package com.ads.Investigationintranet.controller;

import com.ads.Investigationintranet.exception.UserNotFoundException;
import com.ads.Investigationintranet.service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailingController {

  @Autowired
  private MailingService mailingService;

  @PostMapping("/send")
  public ResponseEntity<String> sendEmails(@RequestBody List<String> emailList) throws UserNotFoundException {
    mailingService.sendEmails(emailList);
    return ResponseEntity.ok("Emails sent successfully.");
  }

}
