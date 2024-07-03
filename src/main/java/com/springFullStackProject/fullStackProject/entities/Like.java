package com.springFullStackProject.fullStackProject.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="p_like")
@Data
public class Like {

	@Id
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)  // Post çağırıldığında user objesini direkt getirme
	@JoinColumn(name="post_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE) // user silindiğinde postlari da uçur
	@JsonIgnore // serialization'da sorun yaratmasın diye
	private Post post;	
	
	@ManyToOne(fetch = FetchType.LAZY)  // Post çağırıldığında user objesini direkt getirme
	@JoinColumn(name="user_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE) // user silindiğinde postlari da uçur
	@JsonIgnore // serialization'da sorun yaratmasın diye
	private User user;	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
