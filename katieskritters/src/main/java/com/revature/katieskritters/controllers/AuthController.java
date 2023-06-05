package com.revature.katieskritters.controllers;

import java.lang.module.ResolutionException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.katieskritters.dtos.requests.NewUserRequest;
import com.revature.katieskritters.services.UserService;
import com.revature.katieskritters.utils.customExceptions.ResourceConflictException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody NewUserRequest reqest) {
        // check unique username
        if (!userService.isUniqueUsername(reqest.getUsername())) {
            throw new ResolutionException("Username is not unique!");
        }

        // username is valid

        // check password

        // check passwords are the same

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    // dto = data transfer object

    // @GetMapping("/get")

    // @PutMapping("/update")

    // @DeleteMapping("/delete")
    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<Map<String, Object>> handleResourceConflictException(ResolutionException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new Date(System.currentTimeMillis()));
        map.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(map);
    }
}