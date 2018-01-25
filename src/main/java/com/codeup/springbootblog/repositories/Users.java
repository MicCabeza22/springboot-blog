package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
