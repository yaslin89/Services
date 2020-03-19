package com.service.user.dao;


import org.springframework.data.repository.CrudRepository;

import com.service.user.entitys.User;


public interface UserRepository extends CrudRepository<User, Long> {

}
