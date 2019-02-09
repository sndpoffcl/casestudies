package com.cg.blog.daoservices;

import com.cg.blog.beans.Blog;
import com.cg.blog.beans.User;
import com.cg.blog.util.BlogDBUtil;

public class BlogDAOImpl implements BlogDAO{

	@Override
	public User findOne(String username) {

		return BlogDBUtil.users.get(username);
		
	}

	@Override
	public User saveUser(User user) {
		user.setUserId(BlogDBUtil.getUSER_ID_COUNTER());
		BlogDBUtil.users.put(user.getUsername(),user);
		return user;
		
	}

	@Override
	public Blog saveBlog(Blog blog) {
		
		return null;
	}

	@Override
	public boolean updateBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

}
