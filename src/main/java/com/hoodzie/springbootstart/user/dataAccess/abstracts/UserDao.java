package com.hoodzie.springbootstart.user.dataAccess.abstracts;

import com.hoodzie.springbootstart.user.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
