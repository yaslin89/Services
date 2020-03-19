package com.service.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.service.user.entitys.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
