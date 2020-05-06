package com.macrun.emagazine.service;

import com.macrun.emagazine.dto.UserDto;

public interface UserService {
    UserDto getById(long id);
}
