package com.greenlanton.greenlanton.service;

import com.greenlanton.greenlanton.dto.SignupRequestDto;
import com.greenlanton.greenlanton.model.User;
import com.greenlanton.greenlanton.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    public void registerUser(SignupRequestDto signupRequestDto){
        //회원 ID중복 확인
        String username = signupRequestDto.getUsername();
        System.out.println("회원 ID : " + username);
        Optional<User> found_username = userRepository.findByUsername(username);
        if (found_username.isPresent()){
            throw new IllegalArgumentException("사용자 ID가 존재합니다.");
        }
        //패스워드 암호화(구현예정)
        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        System.out.println("회원 PW : " + password );
        //이메일
        String email = signupRequestDto.getEmail();
        System.out.println("회원 email : " + email);
        //닉네임
        String nickname = signupRequestDto.getNickname();
        Optional<User> found_nickname= userRepository.findByNickname(signupRequestDto.getNickname());
        if (found_nickname.isPresent()){
            throw new IllegalArgumentException("사용자 닉네임이 존재합니다.");
        }
        System.out.println("회원 nickname : " + nickname);

        User user = new User(username, password, email, nickname);
        userRepository.save(user);
    }

}
