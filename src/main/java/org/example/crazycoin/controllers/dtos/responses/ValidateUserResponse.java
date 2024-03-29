package org.example.crazycoin.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidateUserResponse {
    private String id;
    private String email;
    private String password;
}
