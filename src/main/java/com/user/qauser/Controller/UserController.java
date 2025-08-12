package com.user.qauser.Controller;

import com.user.qauser.Dto.UserRegisterDTO;
import com.user.qauser.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserRegisterDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserRegisterDTO getById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserRegisterDTO create(@RequestBody UserRegisterDTO userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public UserRegisterDTO update(@PathVariable UUID id, @RequestBody UserRegisterDTO userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{id}/hobbies")
    public UserRegisterDTO assignHobbies(@PathVariable UUID id, @RequestBody List<UUID> hobbyIds) {
        return userService.assignHobbies(id, hobbyIds);
    }
}
