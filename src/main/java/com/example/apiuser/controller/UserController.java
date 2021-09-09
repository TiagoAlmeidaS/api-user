package com.example.apiuser.controller;

import com.example.apiuser.domain.UserDTO;
import com.example.apiuser.entity.User;
import com.example.apiuser.exception.UserNotFoundException;
import com.example.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO userDTO) throws UserNotFoundException {

        User user = User.toUserDTO(userDTO);
        service.save(user);
        userDTO.setPass(null);

        return ResponseEntity.ok(userDTO);

    }

}
