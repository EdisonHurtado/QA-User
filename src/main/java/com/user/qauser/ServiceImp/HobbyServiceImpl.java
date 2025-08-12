package com.user.qauser.ServiceImp;

import com.user.qauser.Domain.Hobby;
import com.user.qauser.Dto.HobbyDTO;
import com.user.qauser.Repository.HobbyRepository;
import com.user.qauser.Service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HobbyServiceImpl implements HobbyService {

    private final HobbyRepository hobbyRepository;

    @Override
    public List<HobbyDTO> getAllHobbies() {
        return hobbyRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public HobbyDTO createHobby(HobbyDTO hobbyDto) {
        Hobby hobby = toEntity(hobbyDto);
        return toDto(hobbyRepository.save(hobby));
    }

    @Override
    public void deleteHobby(UUID id) {
        hobbyRepository.deleteById(id);
    }

    private HobbyDTO toDto(Hobby hobby) {
        HobbyDTO dto = new HobbyDTO();
        dto.setIdHobby(hobby.getIdHobby());
        dto.setHobbyName(hobby.getHobbyName());
        dto.setDescription(hobby.getDescription());
        return dto;
    }

    private Hobby toEntity(HobbyDTO dto) {
        Hobby hobby = new Hobby();
        hobby.setHobbyName(dto.getHobbyName());
        hobby.setDescription(dto.getDescription());
        return hobby;
    }
}
