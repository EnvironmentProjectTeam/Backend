package com.greenlanton.greenlanton.controller;

import com.greenlanton.greenlanton.dto.ErrorMessageDto;
import com.greenlanton.greenlanton.dto.SignupRequestDto;
import com.greenlanton.greenlanton.model.User;
import com.greenlanton.greenlanton.repository.UserRepository;
import com.greenlanton.greenlanton.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j // 공부 필요
@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService,UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //회원 가입 요청 처리
    @PostMapping("/user/signup")
    public ErrorMessageDto registerUser(@RequestBody SignupRequestDto signupRequestDto){
        System.out.println("--------------");
        userService.registerUser(signupRequestDto);
        try{
            //시도해 볼 동작
            userService.registerUser(signupRequestDto);
        }catch (Exception e){
            //성공 or 오류 발생 시 나오는 동작
            ErrorMessageDto errorMessageDto = new ErrorMessageDto("true","회원가입에 성공하셨습니다.");
            System.out.println("회원가입에 성공하셨습니다.");
            return errorMessageDto;
        }
        ErrorMessageDto errorMessageDto = new ErrorMessageDto("false", "아이디 또는 비밀번호를 확인해주세요.");
        System.out.println("아이디 또는 비밀번호를 확인해주세요.");
        return errorMessageDto;
    }

    //로그인

}
