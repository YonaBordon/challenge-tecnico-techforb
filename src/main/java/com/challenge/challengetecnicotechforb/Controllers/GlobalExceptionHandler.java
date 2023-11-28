package com.challenge.challengetecnicotechforb.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.challenge.challengetecnicotechforb.Exception.AccessDeniedException;
import com.challenge.challengetecnicotechforb.Exception.BadRequestException;
import com.challenge.challengetecnicotechforb.Exception.InvalidCredentialsException;
import com.challenge.challengetecnicotechforb.Exception.ResourceNotFoundException;
import com.challenge.challengetecnicotechforb.Exception.UserAlreadyExistsException;
import com.challenge.challengetecnicotechforb.Exception.UserNotFoundException;
import com.challenge.challengetecnicotechforb.Security.Payload.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
    return ResponseEntity.status(403).body(new ErrorResponse("Access Denied", e.getMessage()));
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
    return ResponseEntity.status(400).body(new ErrorResponse("Bad Request", e.getMessage()));
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Bad Request", e.getMessage()));
  }

  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<ErrorResponse> handleInvalidCredentialsException(InvalidCredentialsException e) {
    return ResponseEntity.status(401).body(new ErrorResponse("Invalid Credentials", e.getMessage()));
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
    return ResponseEntity.status(404).body(new ErrorResponse("Resource Not Found", e.getMessage()));
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
    return ResponseEntity.status(409).body(new ErrorResponse("User Already Exists", e.getMessage()));
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
    return ResponseEntity.status(404).body(new ErrorResponse("User Not Found", e.getMessage()));
  }

}
