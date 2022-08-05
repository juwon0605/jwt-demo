package com.example.jwtdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtdemo.dto.AuthRequest;
import com.example.jwtdemo.dto.AuthResponse;
import com.example.jwtdemo.service.KakaoAuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final KakaoAuthService kakaoAuthService;

	@PostMapping("/kakao")
	public AuthResponse kakaoAuthRequest(@RequestBody AuthRequest authRequest) {
		log.trace("authRequest={}", authRequest);
		return kakaoAuthService.login(authRequest);
	}

}
