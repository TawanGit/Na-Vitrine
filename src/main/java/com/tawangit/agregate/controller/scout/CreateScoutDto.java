package com.tawangit.agregate.controller.scout;

import java.time.LocalDate;

public record CreateScoutDto(String scoutName, String club, LocalDate dateOfBirth, String email, String password) {

}
