package com.challenge.challengetecnicotechforb.Security.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterRequest {

  private String username;
  private String email;
  private String password;

}
