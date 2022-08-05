package com.example.jwtdemo.service;

import org.springframework.stereotype.Service;

import com.example.jwtdemo.dto.AuthRequest;
import com.example.jwtdemo.dto.AuthResponse;
import com.example.jwtdemo.jwt.AuthToken;
import com.example.jwtdemo.jwt.AuthTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoAuthService {

	private final AuthTokenProvider authTokenProvider;

	public AuthResponse login(AuthRequest authRequest) {
		log.trace("authRequest={}", authRequest);
		//TODO 카카오 API로 유저 정보 가져오기
		String socialId = "This is socialId";

		//TODO builder패턴으로 리팩토링
		AuthResponse authResponse = new AuthResponse();

		AuthToken appToken = authTokenProvider.createUserAppToken(socialId);

		authResponse.setAppToken(appToken.getToken());
		return authResponse;
	}
}
