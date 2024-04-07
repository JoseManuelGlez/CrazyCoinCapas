package org.example.crazycoin.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateExpenseRequest {
    private Double mount;
    private String category;
    private String date;
    private String description;
    private String userId;
}
