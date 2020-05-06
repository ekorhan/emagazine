package com.macrun.emagazine.repository;

import com.macrun.emagazine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
