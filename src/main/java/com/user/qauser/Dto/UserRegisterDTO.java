package com.user.qauser.Dto;

import lombok.Data;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Data
public class UserRegisterDTO {
    private UUID idUser;
    private String name;
    private String email;
    private String passwordHash;
    private Instant dateRegistered;
    private String status;
    private Instant lastConnection;
    private Set<UUID> hobbyIds;
}
