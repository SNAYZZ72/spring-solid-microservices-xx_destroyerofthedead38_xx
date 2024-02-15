package fr.mbds.customer.dtos;

import lombok.*;

@Data @Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
