package com.cg.blog.beans;

import java.util.Date;

public class Blog {
	private String blogTitle;
	private String blogBody;
	private int blogId;
	private String blogAuthor;
	
	public Blog(String name, String blogTitle2, String blogBody2 , int blogId) {
		this.blogAuthor = name;
		this.blogTitle = blogTitle2;
		this.blogBody = blogBody2;
		this.blogId = blogId;
	}

	public Blog(String name, String blogTitle2, String blogBody2, long blogId2) {
		this.blogAuthor = name;
		this.blogTitle = blogTitle2;
		this.blogBody = blogBody2;
		this.blogId = blogId;
	}
	
	
}
