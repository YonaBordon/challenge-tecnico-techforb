package com.challenge.challengetecnicotechforb.Exception;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) {
    super(message);
  }
}