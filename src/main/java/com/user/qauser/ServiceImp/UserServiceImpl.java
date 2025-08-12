package com.user.qauser.ServiceImp;

import com.user.qauser.domain.User;
import com.user.qauser.Domain.Hobby;
import com.user.qauser.Dto.UserRegisterDTO;
import com.user.qauser.Repository.UserRepository;
import com.user.qauser.Repository.HobbyRepository;
import com.user.qauser.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HobbyRepository hobbyRepository;

    @Override
    public List<UserRegisterDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public UserRegisterDTO getUserById(UUID id) {
        return userRepository.findById(id).map(this::toDto).orElseThrow();
    }

    @Override
    public UserRegisterDTO createUser(UserRegisterDTO userDto) {
        User user = toEntity(userDto);
        return toDto(userRepository.save(user));
    }

    @Override
    public UserRegisterDTO updateUser(UUID id, UserRegisterDTO userDto) {
        User user = toEntity(userDto);
        user.setIdUser(id);
        return toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserRegisterDTO assignHobbies(UUID userId, List<UUID> hobbyIds) {
        User user = userRepository.findById(userId).orElseThrow();
        List<Hobby> hobbies = hobbyRepository.findAllById(hobbyIds);
        user.getHobbies().clear();
        user.getHobbies().addAll(hobbies);
        return toDto(userRepository.save(user));
    }

    private UserRegisterDTO toDto(User user) {
        UserRegisterDTO dto = new UserRegisterDTO();
        dto.setIdUser(user.getIdUser());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPasswordHash(user.getPasswordHash());
        dto.setDateRegistered(user.getDateRegistered());
        dto.setStatus(user.getStatus());
        dto.setLastConnection(user.getLastConnection());
        dto.setHobbyIds(user.getHobbies().stream().map(Hobby::getIdHobby).collect(Collectors.toSet()));
        return dto;
    }

    private User toEntity(UserRegisterDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(dto.getPasswordHash());
        user.setDateRegistered(dto.getDateRegistered() != null ? dto.getDateRegistered() : java.time.Instant.now());
        user.setStatus(dto.getStatus());
        user.setLastConnection(dto.getLastConnection());
        if (dto.getHobbyIds() != null) {
            user.setHobbies(new java.util.HashSet<>(hobbyRepository.findAllById(dto.getHobbyIds())));
        }
        return user;
    }
}
