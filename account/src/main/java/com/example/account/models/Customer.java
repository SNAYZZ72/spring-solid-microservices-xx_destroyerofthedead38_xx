package com.example.account.models;

import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
