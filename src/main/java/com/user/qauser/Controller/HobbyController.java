package com.user.qauser.Controller;

import com.user.qauser.Dto.HobbyDTO;
import com.user.qauser.Service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hobbies")
@RequiredArgsConstructor
public class HobbyController {

    private final HobbyService hobbyService;

    @GetMapping
    public List<HobbyDTO> getAll() {
        return hobbyService.getAllHobbies();
    }

    @PostMapping
    public HobbyDTO create(@RequestBody HobbyDTO hobbyDto) {
        return hobbyService.createHobby(hobbyDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        hobbyService.deleteHobby(id);
    }
}
