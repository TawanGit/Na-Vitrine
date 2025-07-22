package com.tawangit.agregate.controller.dtos;

import com.tawangit.agregate.controller.trialist.TrialistPosition;

import java.time.LocalDate;

public record TrialistUpdate(LocalDate dateOfBirth, String document, String cellphone,
                             String name, TrialistPosition position) {

}
