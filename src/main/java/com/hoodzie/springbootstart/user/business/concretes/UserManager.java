package com.hoodzie.springbootstart.user.business.concretes;

import com.hoodzie.springbootstart.core.exceptions.UserNotFoundException;
import com.hoodzie.springbootstart.user.business.abstracts.UserService;
import com.hoodzie.springbootstart.user.entities.dtos.UserDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserManager implements UserService {

    private static List<UserDTO> users = new ArrayList<>();

    static {
        users.add(new UserDTO(1L,"Kutay", LocalDate.now().minusYears(27)));
        users.add(new UserDTO(2L,"Seda",LocalDate.now().minusYears(27)));
        users.add(new UserDTO(3L,"İbi",LocalDate.now().minusYears(2)));
        users.add(new UserDTO(4L,"Dibi",LocalDate.now().minusYears(2)));
    }
    @Override
    public List<UserDTO> getUsers() {
        return users;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElseThrow(
                () -> new UserNotFoundException(String.format("User Not Found ID : %s", userId))
                );

    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        UserDTO last = users.get(users.size() - 1);
        long id = last.getId() + 1;
        user.setId(id);
        users.add(user);
        return user;
    }

    @Override
    public void deleteUserById(Long userId) throws UserNotFoundException {
        users.removeIf(u -> u.getId().equals(userId));
    }


}
