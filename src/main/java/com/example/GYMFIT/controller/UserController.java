package com.example.GYMFIT.controller;

import com.example.GYMFIT.dto.UserFormDto;
import com.example.GYMFIT.entity.User;
import com.example.GYMFIT.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController  //컨트롤러선언
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/new")
    public String newUser(@RequestBody UserFormDto dto) {   //RequestBody는 Json데이터로 받아와야함
        User user = dto.toEntity();
        log.info(user.toString());
        User saved = userRepository.save(user);
        log.info(saved.toString());
        return "";
    }

}



