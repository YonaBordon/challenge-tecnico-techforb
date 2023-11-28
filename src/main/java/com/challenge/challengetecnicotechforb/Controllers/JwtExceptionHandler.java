package com.challenge.challengetecnicotechforb.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;

@ControllerAdvice
public class JwtExceptionHandler {
  @ExceptionHandler(JwtException.class)
  public ResponseEntity<String> handleJwtException(JwtException e) {
    return ResponseEntity.status(401).body(e.getMessage());
  }

  @ExceptionHandler({ ExpiredJwtException.class })
  public ResponseEntity<String> handleExpiredJwtException(ExpiredJwtException e) {
    return ResponseEntity.status(401).body(e.getMessage());
  }

}
