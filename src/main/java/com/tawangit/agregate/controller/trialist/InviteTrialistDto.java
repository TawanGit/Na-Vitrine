package com.tawangit.agregate.controller.trialist;

import com.tawangit.agregate.entity.Scout;

import java.util.UUID;

public record InviteTrialistDto(String email, UUID scoutId) {
}
