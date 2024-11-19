package com.league.jogobonito.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PlayerDTO {
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "La posición no puede estar vacía")
    private String position;

    @NotBlank(message = "El número de camiseta no puede estar vacío")
    private String jerseyNumber;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @Past(message = "La fecha de nacimiento debe estar en el pasado")
    private Date birthDate;

    @Positive(message = "La altura debe ser un valor positivo")
    private Integer heightCm;

    @NotBlank(message = "El país de nacimiento no puede estar vacío")
    private String countryOfBirth;

    @NotNull(message = "El ID del equipo no puede estar vacío")
    private Integer teamId;
}
