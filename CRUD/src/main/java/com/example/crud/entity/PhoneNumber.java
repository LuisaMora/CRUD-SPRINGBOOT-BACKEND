package com.example.crud.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

    @NotBlank(message = "El número de teléfono no puede estar en blanco")
    @Pattern(regexp = "\\d{10}", message = "El número de teléfono debe tener 10 dígitos numéricos")
    private String number;

    @NotBlank(message = "El tipo de teléfono no puede estar en blanco")
    private String type;
}
