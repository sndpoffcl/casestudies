package com.cg.blog.services;

import com.cg.blog.exceptions.InvalidUserNameException;
import com.cg.blog.exceptions.ServerDownException;

public interface BlogServices {
	int registration(String username, String password, String name) throws InvalidUserNameException , ServerDownException;
}
