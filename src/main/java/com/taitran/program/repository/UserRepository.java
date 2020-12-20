package com.taitran.program.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taitran.program.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  Optional<UserEntity> findByUserName(String userName);
}
