package com.cg.blog.daoservices;

import com.cg.blog.beans.Blog;
import com.cg.blog.beans.User;

public interface BlogDAO {
	User findOne(String username);
	User saveUser(User user);
	Blog saveBlog(Blog blog);
	boolean updateBlog(int blogId);
	
	
}
