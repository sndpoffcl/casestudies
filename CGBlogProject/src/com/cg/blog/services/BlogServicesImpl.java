package com.cg.blog.services;

import java.util.HashMap;

import com.cg.blog.beans.Blog;
import com.cg.blog.beans.User;
import com.cg.blog.daoservices.BlogDAO;
import com.cg.blog.daoservices.BlogDAOImpl;
import com.cg.blog.exceptions.BlogNotFoundException;
import com.cg.blog.exceptions.BlogSizeInvalidException;
import com.cg.blog.exceptions.BlogTitleInvalidException;
import com.cg.blog.exceptions.InvalidPasswordException;
import com.cg.blog.exceptions.InvalidUserNameException;
import com.cg.blog.exceptions.ServerDownException;
import com.cg.blog.exceptions.UserNotFoundException;
import com.cg.blog.util.BlogDBUtil;

public class BlogServicesImpl implements BlogServices{
	
	BlogDAO blogDao = new BlogDAOImpl();

	@Override
	public String registration(String username, String password, String name)
			throws InvalidUserNameException, ServerDownException {
		if(BlogDBUtil.users.containsKey(username))
			throw new InvalidUserNameException("this username already exists kindly change");
		HashMap<Integer, Blog> blogs = new HashMap<Integer, Blog>();
		User newUser = new User( username, password , name , blogs);
		newUser = blogDao.saveUser(newUser);
		return newUser.getUsername();
	}

	@Override
	public String signIn(String username, String password)
			throws UserNotFoundException, InvalidPasswordException, ServerDownException {
		User user = getUserDetails(username);
		if(user.getPassword().equals(password)) {
			return user.getUsername();
		}else {
			throw new InvalidPasswordException("Please enter proper password . This password is invalid ");
		}
		
	}
	

	@Override
	public boolean createNewBlog(String blogTitle, String blogBody , String username)
			throws BlogTitleInvalidException, BlogSizeInvalidException, ServerDownException, UserNotFoundException {
		if(blogTitle.length()<4 || blogTitle.length()>26)
			throw new BlogTitleInvalidException("Title length should be more than 4 and less than 26");
		if(blogBody.length()<32 || blogBody.length()>230)
			throw new BlogSizeInvalidException("Blog body should be more than 32 words and less than 230 words");
		
		User user = getUserDetails(username);
		Blog blog = 
		return false;
	}

	@Override
	public int deleteBlog(int blogId) throws BlogNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int showAllBlogs(int blogId) throws UserNotFoundException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int showAllBlogs(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserDetails(String username) throws UserNotFoundException {
		User user = blogDao.findOne(username);
		if(user==null)
			throw new UserNotFoundException();
		else
			return user;
	}

}
