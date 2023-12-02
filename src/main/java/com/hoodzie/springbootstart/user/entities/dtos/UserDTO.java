package com.hoodzie.springbootstart.user.entities.dtos;

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

    private String name;

    private LocalDate birthDate;
}
