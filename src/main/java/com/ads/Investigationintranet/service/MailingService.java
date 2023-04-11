package com.ads.Investigationintranet.service;

import com.ads.Investigationintranet.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface MailingService {
  ResponseEntity<String> sendEmails(List<String> emailList) throws UserNotFoundException;
}
