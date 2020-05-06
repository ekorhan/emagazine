package com.macrun.emagazine.service;

import com.macrun.emagazine.dto.CommentDto;

public interface CommentService {
    CommentDto getById(long id);
}
