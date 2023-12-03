package com.hoodzie.springbootstart.user.entities.dtos;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

    @Serial
    private static final long serialVersionUID = 1014367461247591925L;

    private Long id;

    @Size(min = 2, message = "Name must be at least 2 characters")
    private String name;

    @Past(message = "Birth Date must be in the past")
    private LocalDate birthDate;
}
