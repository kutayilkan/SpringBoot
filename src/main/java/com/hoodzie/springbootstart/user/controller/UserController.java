package com.hoodzie.springbootstart.user.controller;

import com.ctc.wstx.shaded.msv_core.util.Uri;
import com.hoodzie.springbootstart.user.business.abstracts.UserService;
import com.hoodzie.springbootstart.user.entities.dtos.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/users")
@Tag(name = "User Controller")
public class UserController {

    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId) {
        UserDTO user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Uri> saveUser(@Valid @RequestBody UserDTO user) {
        UserDTO savedUser = userService.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    // HATEOS _links
    @GetMapping("hal/{id}")
    @Operation(description = "Hateos tarzında HAL")
    public EntityModel<UserDTO> getUserByIdHal(@PathVariable("id") Long userId) {
        UserDTO user = userService.getUserById(userId);

        EntityModel<UserDTO> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn((this.getClass())).getUsers()); // linkTo içerisinde methodon methoduyla verilebilir.
        entityModel.add(link.withRel("get-users"));
        return entityModel; // Static EntityModel method.
    }

}
