package com.example.ticketingSystem.controller;


import com.example.ticketingSystem.dto.UserDto;
import com.example.ticketingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/login")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }
    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/getUsers")
    public List<UserDto> getUser() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDto userDto) {
        return userService.deleteUser(userDto);
    }

//    @PostMapping("/register")
//    public String register(@RequestBody UserDto userDTO) {
//        return userService.register(userDTO);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody UserDto userDTO) {
//        return userService.login(userDTO);
//    }

//    @PostMapping("/doLogin")
//    public ResponseEntity<LoginResponse> doLogin(RequestBody UserDto userdto){
//        LoginResponse response = new LoginResponse();
//        response.setToken("token_details");
//
//        String result = loginService.login(userDto);
//        return new ResponseEntity<LoginResponse>()
//
//
//    }


}
