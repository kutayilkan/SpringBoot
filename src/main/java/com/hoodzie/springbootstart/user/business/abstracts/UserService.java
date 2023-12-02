package com.hoodzie.springbootstart.user.business.abstracts;

import com.hoodzie.springbootstart.user.entities.dtos.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO getUserById(Long userId);
}
