package com.macrun.emagazine.api;

import com.macrun.emagazine.dto.PostDto;
import com.macrun.emagazine.service.implementation.PostServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/index")
public class PostApi {

    private final PostServiceImplementation postServiceImplementation;

    public PostApi(PostServiceImplementation postServiceImplementation) {
        this.postServiceImplementation = postServiceImplementation;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable("id") Long id) {
        PostDto postDto = postServiceImplementation.getById(id);
        return ResponseEntity.ok(postDto);
    }

    @PostMapping
    public ResponseEntity<PostDto> addPost(@Valid @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postServiceImplementation.addPost(postDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") Long id, @Valid @RequestBody PostDto postDto) {
        PostDto updatedPost = postServiceImplementation.updatePost(id, postDto);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PostDto> deletePost(@PathVariable(value = "id") Long id) {
        PostDto postDto = postServiceImplementation.deletePost(id);
        return ResponseEntity.ok(postDto);
    }
}
