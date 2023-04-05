//package com.ads.Investigationintranet.security;
//
//
//import com.ads.Investigationintranet.domain.auth.User;
//import com.ads.Investigationintranet.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthenticationService {
//
//  @Autowired
//  private TokenUtil tokenUtil;
//
//  @Autowired
//  private UserService userService;
//
//  @Autowired
//  private AuthenticationManager authenticationManager;
//
//  public LoginResponse login(LoginRequest request) throws Exception {
//    final Authentication authentication=authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
//    );
//    User user=userService.loadUserByUsername(request.getUsername());
//    if(user == null || !user.checkPassword(request.getPassword())) {
//      throw new Exception("username or Password incorrect");
//    }
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//    String token=tokenUtil.generateToken(user);
//    return new LoginResponse(token);
//  }
//}
