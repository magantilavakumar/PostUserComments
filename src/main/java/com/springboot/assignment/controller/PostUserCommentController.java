package com.springboot.assignment.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springboot.assignment.beans.Comment;
import com.springboot.assignment.beans.Post;

@RestController
@RequestMapping(value = "/User")
public class PostUserCommentController {
	
	private Logger logger = LoggerFactory.getLogger(PostUserCommentController.class);
	
	@Autowired
	public ObjectMapper objectMapper;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Value("${url.posts}")
	private String urlPosts;
	
	@Value("${url.comments}")
	private String urlComments;
	
	@Autowired
	private HttpEntity<String> httpJSONEntity;

	public List<Post> getLstOfPostFromJson() throws JsonMappingException, JsonProcessingException{
		String postsJson = restTemplate.exchange(urlPosts, HttpMethod.GET, httpJSONEntity, String.class).getBody();
	    List<Post> lstOfPosts = objectMapper.readValue(postsJson, new TypeReference<List<Post>>() {});
	    return lstOfPosts;
	}
	
	public List<Comment> getLstOfCommentsFromJson() throws JsonMappingException, JsonProcessingException{
		String postsJson = restTemplate.exchange(urlComments, HttpMethod.GET, httpJSONEntity, String.class).getBody();
	    List<Comment> lstOfComments = objectMapper.readValue(postsJson, new TypeReference<List<Comment>>() {});
	    return lstOfComments;
	}

	@GetMapping(value ="/getTopPost")
	public String getPosts() throws JsonMappingException, JsonProcessingException {
	    List<Comment> lstOfComments = getLstOfCommentsFromJson();
	    List<Post> lstOfPosts = getLstOfPostFromJson();
	    Map<Integer, List<Comment>> commentslistGroupedByPost = lstOfComments.stream()
	            .collect(Collectors.groupingBy(Comment::getPostId, Collectors.toList()));
	    List<Post> postMap =  lstOfPosts.stream().sorted()
	    				.map(p->new Post(0,p.getId(),p.getTitle(),p.getBody(),commentslistGroupedByPost.get(p.getId()).size()))
	    				.collect(Collectors.toList());
	    return objectMapper.writeValueAsString(postMap);
	}
	/*
	 * Post: Input as text in body
	 * ex: field1,field2
	 */
	@PostMapping(value = "/getComments")
	public String getComments(@RequestBody(required = true)String requiredFields) throws JsonMappingException, JsonProcessingException {
	    List<Comment> lstOfComments = getLstOfCommentsFromJson();
	    String[] requiredParam = requiredFields.split(",");
	    logger.info(requiredFields);
	    SimpleFilterProvider filterProvider = new SimpleFilterProvider();
	    filterProvider.addFilter("myCommentFilter", SimpleBeanPropertyFilter.filterOutAllExcept(requiredParam));
	    objectMapper.setFilterProvider(filterProvider);
	    return objectMapper.writeValueAsString(lstOfComments);
	}
	
	

}
