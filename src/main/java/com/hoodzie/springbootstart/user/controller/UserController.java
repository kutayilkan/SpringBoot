package com.hoodzie.springbootstart.user.controller;

import com.hoodzie.springbootstart.core.exceptions.UserNotFoundException;
import com.hoodzie.springbootstart.user.business.abstracts.UserService;
import com.hoodzie.springbootstart.user.entities.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity getUserById(@PathVariable("id") Long userId){
         UserDTO user = userService.getUserById(userId);

         if (user == null)
             throw new UserNotFoundException(String.format("User Not Found ID : %s", userId));

    return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDTO user){
        UserDTO savedUser = userService.saveUser(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .path("/{id}")
                    .buildAndExpand(savedUser.getId())
                    .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

}
