package com.user.qauser.Service;

import com.user.qauser.Dto.HobbyDTO;
import java.util.List;
import java.util.UUID;

public interface HobbyService {
    List<HobbyDTO> getAllHobbies();
    HobbyDTO createHobby(HobbyDTO hobbyDto);
    void deleteHobby(UUID id);
}
