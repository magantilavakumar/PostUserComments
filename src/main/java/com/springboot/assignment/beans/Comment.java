/**
 * 
 */
package com.springboot.assignment.beans;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author magantilavakumar
 *
 */
@JsonFilter("myCommentFilter")
public class Comment {

	private int postId;
	private int id;
	private String name;
	private String email;
	private String body;

	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param postId
	 * @param id
	 * @param name
	 * @param email
	 * @param body
	 */
	public Comment(int postId, int id, String name, String email, String body) {
		this.postId = postId;
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
	}
	
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
