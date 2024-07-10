package com.springFullStackProject.fullStackProject.responses;

import lombok.Data;

@Data
public class AuthResponse {

	private String message;
	private Long userId;
	private int avatarId;
	private String accessToken;
	private String refreshToken;
	
	public int getAvatarId() {
		return avatarId;
	}
	public void setAvatarId(int avatarId) {
		this.avatarId = avatarId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}
