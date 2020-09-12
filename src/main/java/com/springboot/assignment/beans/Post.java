/**
 * 
 */
package com.springboot.assignment.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author magantilavakumar
 *
 */

public class Post implements Comparable<Post> {

	/**
	 * 
	 */
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param userId
	 * @param id
	 * @param title
	 * @param body
	 */
	public Post(int userId, int id, String title, String body,int noOfComments) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
		this.noOfComments = noOfComments;
	}
	
	private int userId;
	@JsonProperty("post_id")
	private int id;
	@JsonProperty("post_title")
	private String title;
	@JsonProperty("post_body")
	private String body;
	@JsonProperty("total_number_of_comments")
	private int noOfComments;
	/**
	 * @return the noOfComments
	 */
	@JsonProperty("total_number_of_comments")
	public int getNoOfComments() {
		return noOfComments;
	}

	/**
	 * @param noOfComments the noOfComments to set
	 */
	@JsonProperty("noOfComments")
	public void setNoOfComments(int noOfComments) {
		this.noOfComments = noOfComments;
	}

	/**
	 * @return the userId
	 */
	@JsonIgnore
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the id
	 */
	@JsonProperty("post_id")
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	@JsonProperty("post_title")
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the body
	 */
	@JsonProperty("post_body")
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	@JsonProperty("body")
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int compareTo(Post o) {
		// TODO Auto-generated method stub
		return (noOfComments-o.noOfComments);
	}
	
	

}
