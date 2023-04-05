//package com.ads.Investigationintranet.security;
//
//import com.ads.Investigationintranet.domain.auth.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class TokenUtil {
//
//  @Value("${authentication.expiration.delay}")
//  private Long tokenValidity=604800L;
//
//  @Value("${authentication.secret}")
//  private String tokenSecret;
//
//  public String generateToken(User user) {
//    Map<String,Object> claims=new HashMap<>();
//    claims.put("userId",user.getHhhId());
//    claims.put("username",user.getUsername());
//    claims.put("sub",user.getUsername());
//    claims.put("created",new Date());
//    claims.put("role",user.getAuthorities());
//    return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512,tokenSecret).compact();
//  }
//
//  public String getUserNameFromToken(String token) {
//    try {
//      Claims claims=getClaims(token);
//      return claims.getSubject();
//    } catch(Exception ex) {
//      return null;
//    }
//  }
//
//  private Date generateExpirationDate() {
//    return new Date(System.currentTimeMillis() + tokenValidity * 1000);
//  }
//
//  public boolean isTokenValid(String token,UserDetails userDetails) {
//    String username=getUserNameFromToken(token);
//
//    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//  }
//
//  private boolean isTokenExpired(String token) {
//    Date expiration=getClaims(token).getExpiration();
//    return expiration.before(new Date());
//  }
//
//  private Claims getClaims(String token) {
//    Claims claims;
//    try {
//      claims=Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
//    } catch(Exception ex) {
//      claims=null;
//    }
//    return claims;
//  }
//}
//
