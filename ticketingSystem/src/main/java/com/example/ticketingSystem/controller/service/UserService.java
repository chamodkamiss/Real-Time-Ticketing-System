package com.example.ticketingSystem.controller.service;

import com.example.ticketingSystem.controller.dto.UserDto;
import com.example.ticketingSystem.controller.entity.User;
import com.example.ticketingSystem.controller.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto saveUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }

    public UserDto getUserByUsername(String username) {
        User user = userRepo.findByUsername(username);
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> getAllUsers() {
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDto>>(){}.getType());
    }
    public boolean deleteUser(UserDto userDto) {
        userRepo.delete(modelMapper.map(userDto, User.class));
        return true;
    }

////    @Autowired
////    private PasswordEncoder passwordEncoder;
//
//    public String register(UserDto userDto){
//        if (userRepo.findByUsername(userDto.getUsername()).isPresent()) {
//            throw new RuntimeException("User already exists");
//        }
//
//        User user = new User();
//        user.setUsername(userDto.getUsername());
////        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setRole("ROLE_USER");
//        userRepo.save(user);
//        return "User registered successfully!";
//    }
//
//    public String login(UserDto userDTO) {
//        User user = userRepo.findByUsername(userDTO.getUsername())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
////        if (!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
////            throw new RuntimeException("Invalid credentials");
////        }
//
//        return "Login successful!";
//    }

}



//    public String login(User user){
//        Optional<User> users = loginRepo.findByUsername(user.getUsername());
//        if (users.isPresent()){
//            return "user detail found.";
//        }
//        return "user detail not found.";
//    }

//}
