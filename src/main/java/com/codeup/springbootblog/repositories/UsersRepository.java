package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
