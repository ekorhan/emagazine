package com.macrun.emagazine.repository;

import com.macrun.emagazine.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<UserComment, Long> {
}
