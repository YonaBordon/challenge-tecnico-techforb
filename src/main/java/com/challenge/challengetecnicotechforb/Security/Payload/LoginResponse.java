package com.challenge.challengetecnicotechforb.Security.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {

  private String token;
  private String type = "Bearer";
  private String username;
  private String message;
}
