package com.springFullStackProject.fullStackProject.responses;

import java.util.List;

import com.springFullStackProject.fullStackProject.entities.Post;

import lombok.Data;

@Data
public class PostResponse {

	private Long id;
	private Long userId;
	private String userName;
	private String title;
	private String text;
	private List<LikeResponse> postLike;
	
	public PostResponse(Post entity, List<LikeResponse> postLike) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.title = entity.getTitle();
		this.text = entity.getText();
		this.postLike = postLike;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}



	public List<LikeResponse> getPostLike() {
		return postLike;
	}



	public void setPostLike(List<LikeResponse> postLike) {
		this.postLike = postLike;
	}
	
	
}
