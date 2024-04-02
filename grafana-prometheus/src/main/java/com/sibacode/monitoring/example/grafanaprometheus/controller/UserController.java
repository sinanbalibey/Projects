package com.sibacode.monitoring.example.grafanaprometheus.controller;


import com.sibacode.monitoring.example.grafanaprometheus.model.UserEntity;
import com.sibacode.monitoring.example.grafanaprometheus.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/findAll")
    @ResponseBody
    public ResponseEntity<List<UserEntity>> findAll() {
        return new ResponseEntity<List<UserEntity>>(this.userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody UserEntity user) throws Exception {
        this.userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Void> delete(@RequestParam String username) throws Exception {
        this.userService.delete(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
