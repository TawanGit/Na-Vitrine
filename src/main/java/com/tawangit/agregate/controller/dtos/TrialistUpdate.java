package com.tawangit.agregate.controller.dtos;

import com.tawangit.agregate.controller.trialist.TrialistPosition;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TrialistUpdate(
        @NotNull(message = "The date of birth is required")
        @jakarta.validation.constraints.Past(message = "Date of birth must be in the past")
        LocalDate dateOfBirth,
        @NotBlank(message = "The document is required")
                             @jakarta.validation.constraints.Pattern(regexp = "\\d{11}", message = "Document must be 11 digits")
        String document,
        @NotBlank(message = "The cellphone is required")
                             @jakarta.validation.constraints.Pattern(regexp = "\\d{11}", message = "Cellphone must be 11 digits")
        String cellphone,
                             @NotBlank(message = "The name is required")
                             String name,
        @NotNull(message = "The position is required")
        TrialistPosition position) {

}
