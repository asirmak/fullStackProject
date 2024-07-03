package com.springFullStackProject.fullStackProject.requests;

import lombok.Data;

@Data
public class CommentUpdateRequest {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
