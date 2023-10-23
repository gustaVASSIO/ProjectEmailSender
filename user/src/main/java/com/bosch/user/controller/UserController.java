package com.bosch.user.controller;

import com.bosch.user.dto.UserDTO;
import com.bosch.user.models.UserModel;
import com.bosch.user.service.classes.UserServiceImp;
import com.bosch.user.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> postUser(@RequestBody @Valid UserDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(dto));
    }
}
