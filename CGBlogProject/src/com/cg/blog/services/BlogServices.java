package com.cg.blog.services;

import com.cg.blog.beans.Blog;
import com.cg.blog.beans.User;
import com.cg.blog.exceptions.BlogNotFoundException;
import com.cg.blog.exceptions.BlogSizeInvalidException;
import com.cg.blog.exceptions.BlogTitleInvalidException;
import com.cg.blog.exceptions.InvalidPasswordException;
import com.cg.blog.exceptions.InvalidUserNameException;
import com.cg.blog.exceptions.ServerDownException;
import com.cg.blog.exceptions.UserNotFoundException;

public interface BlogServices {
	
	String registration(String username, String password, String name) throws InvalidUserNameException , ServerDownException;
	String signIn(String username, String password) throws UserNotFoundException, InvalidPasswordException, ServerDownException;
	Blog createNewBlog(String blogTitle, String blogBody, String username) throws BlogTitleInvalidException , BlogSizeInvalidException , ServerDownException, UserNotFoundException;
	int deleteBlog(int blogId) throws BlogNotFoundException;
	int showAllBlogs(String username) throws UserNotFoundException;
	User getUserDetails(String username) throws UserNotFoundException;
}
