//package com.ads.Investigationintranet.controller;
//
//
//import com.ads.Investigationintranet.security.AuthenticationService;
//import com.ads.Investigationintranet.security.LoginRequest;
//import com.ads.Investigationintranet.security.LoginResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/authenticate")
//public class AuthenticationController {
//  @Autowired
//  AuthenticationService authenticationService;
//
//  @PostMapping(value = {"","/"})
//  public LoginResponse login(@RequestBody LoginRequest request) throws Exception {
//    return authenticationService.login(request);
//  }
//}
