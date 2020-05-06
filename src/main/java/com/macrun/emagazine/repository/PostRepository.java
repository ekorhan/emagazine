package com.macrun.emagazine.repository;

import com.macrun.emagazine.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
