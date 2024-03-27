package com.example.GYMFIT.service;

import com.example.GYMFIT.dto.UserFormDto;
import com.example.GYMFIT.entity.User;
import com.example.GYMFIT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public User create(UserFormDto dto) {
        User user = dto.toEntity(); //dto->엔티티로 변환한 후 User에 저장
        return userRepository.save(user);  //user을 DB에 저장
    }

}
