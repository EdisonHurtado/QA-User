package com.user.qauser.Service;

import com.user.qauser.Dto.UserRegisterDTO;
import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserRegisterDTO> getAllUsers();
    UserRegisterDTO getUserById(UUID id);
    UserRegisterDTO createUser(UserRegisterDTO userDto);
    UserRegisterDTO updateUser(UUID id, UserRegisterDTO userDto);
    void deleteUser(UUID id);
    UserRegisterDTO assignHobbies(UUID userId, List<UUID> hobbyIds);
}
