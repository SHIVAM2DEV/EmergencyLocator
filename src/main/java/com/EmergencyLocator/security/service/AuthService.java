package com.EmergencyLocator.security.service;

import com.EmergencyLocator.User.entity.User;
import com.EmergencyLocator.User.repository.UserRepo;
import com.EmergencyLocator.security.dto.LoginRequestDto;
import com.EmergencyLocator.security.dto.LoginResponseDto;
import com.EmergencyLocator.security.dto.SignInRequestDto;
import com.EmergencyLocator.security.utils.AuthUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepo userRepo;


    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
      Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUserName(), loginRequestDto.getPassword())
        );

     User user = (User) authentication.getPrincipal();
        log.info("user login request for {}", user);
     String token = authUtil.generateAccessToken(user);

     log.info("token {} generated for user {}",token, user);
     return new LoginResponseDto(token, user.getId());
    }

    public SignInRequestDto signIn(SignInRequestDto sign) {
        return userRepo.save(sign);
    }

//
//    public SignInResponseDto signIn(SignInRequestDto sign) {
//        return
//    }
}
