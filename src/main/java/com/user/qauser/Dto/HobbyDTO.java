package com.user.qauser.Dto;

import lombok.Data;
import java.util.UUID;

@Data
public class HobbyDTO {
    private UUID idHobby;
    private String hobbyName;
    private String description;
}
