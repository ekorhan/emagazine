package com.macrun.emagazine.service.implementation;

import com.macrun.emagazine.dto.UserDto;
import com.macrun.emagazine.entity.User;
import com.macrun.emagazine.repository.UserRepository;
import com.macrun.emagazine.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImplementation(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto getById(long id) {
        User user = userRepository.getOne(id);
        return modelMapper.map(user, UserDto.class);
    }
}
