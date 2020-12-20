package com.taitran.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taitran.program.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
