package com.example.jwtdemo.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

@Component
public class AuthTokenProvider {

	//TODO @Value로 설정하기
	private String expiry = "100000";

	//TODO secreKey에 @Value 사용하기
	private String secretKey = "0123456789012345678901234567890123456789";
	private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

	public AuthToken createToken(String id, String role, String expiry) {
		Date expiryDate = new Date(System.currentTimeMillis() + Long.parseLong(expiry));
		return new AuthToken(id, role, expiryDate, key);
	}

	public AuthToken createUserAppToken(String id) {
		//TODO RoleType enum으로 리팩토링
		String role = "USER";
		return createToken(id, role, expiry);
	}
}
