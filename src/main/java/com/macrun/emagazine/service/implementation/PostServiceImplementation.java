package com.macrun.emagazine.service.implementation;

import com.macrun.emagazine.dto.PostDto;
import com.macrun.emagazine.entity.Post;
import com.macrun.emagazine.repository.PostRepository;
import com.macrun.emagazine.service.PostService;
import com.macrun.emagazine.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImplementation(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto addPost(PostDto post) {
        Post mainPost = modelMapper.map(post, Post.class);
        mainPost = postRepository.save(mainPost);
        post.setId(mainPost.getId());
        return modelMapper.map(mainPost, PostDto.class);
    }

    @Override
    public PostDto getById(long id) {
        checkExist(id);
        Post post = postRepository.getOne(id);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public TPage<PostDto> getAllPageable(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        PostDto[] postDtoTPage = modelMapper.map(posts.getContent(), PostDto[].class);
        TPage<PostDto> ins = new TPage<>();
        ins.setStat(posts, Arrays.asList(postDtoTPage));
        return ins;
    }

    public PostDto updatePost(Long id, PostDto postDto) {
        checkExist(id);
        Post postDb = postRepository.getOne(id);
        postDb.setTitle(postDto.getTitle());
        postDb.setContent(postDto.getPostContent());
        postDb.setUpdatedAt(new Date());
        postRepository.save(postDb);
        return modelMapper.map(postDb, PostDto.class);
    }

    public PostDto deletePost(Long id) {
        checkExist(id);
        Post post = postRepository.getOne(id);
        PostDto postDto = modelMapper.map(post, PostDto.class);
        postRepository.delete(post);
        return postDto;
    }

    private void checkExist(Long id) {
        if (!postRepository.existsById(id))
            throw new IllegalStateException("This post hasn't been existed");
    }
}
