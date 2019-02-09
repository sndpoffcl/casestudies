package com.cg.blog.beans;

import java.util.Date;

public class Blog {
	private String blogTitle;
	private String blogBody;
	private int blogId;
	private String blogAuthor;
	
	public Blog(String name, String blogTitle2, String blogBody2) {
		this.blogAuthor = name;
		this.blogTitle = blogTitle2;
		this.blogBody = blogBody2;
	}
	
	
}
