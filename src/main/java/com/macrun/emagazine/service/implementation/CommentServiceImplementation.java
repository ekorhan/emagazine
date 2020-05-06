package com.macrun.emagazine.service.implementation;

import com.macrun.emagazine.dto.CommentDto;
import com.macrun.emagazine.entity.UserComment;
import com.macrun.emagazine.repository.CommentRepository;
import com.macrun.emagazine.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImplementation(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto getById(long id) {
        UserComment comment = commentRepository.getOne(id);
        return modelMapper.map(comment, CommentDto.class);
    }
}
