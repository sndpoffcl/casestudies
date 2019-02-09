package com.cg.blog.client;

import java.util.Scanner;

import com.cg.blog.beans.User;
import com.cg.blog.exceptions.BlogSizeInvalidException;
import com.cg.blog.exceptions.BlogTitleInvalidException;
import com.cg.blog.exceptions.InvalidPasswordException;
import com.cg.blog.exceptions.InvalidUserNameException;
import com.cg.blog.exceptions.ServerDownException;
import com.cg.blog.exceptions.UserNotFoundException;
import com.cg.blog.services.BlogServices;
import com.cg.blog.services.BlogServicesImpl;

public class MainClass {
	public static void main(String[] args) throws InvalidUserNameException, ServerDownException, UserNotFoundException, InvalidPasswordException, BlogTitleInvalidException, BlogSizeInvalidException {
		BlogServices blogServices = new BlogServicesImpl();
		int switchKey , optionKey;
		Scanner sc = new Scanner(System.in);
		int flag = 1; 
		while(flag==1) {
			System.out.println("PLEASE CHOSE AN OPTION");
			System.out.println("1. REGISTRATION");
			System.out.println("2. SIGN IN ");
			System.out.println("3. EXIT");
			optionKey = sc.nextInt();
			if(optionKey==1) {
				System.out.println("\t\t*********USER REGISTRATION*********");
				System.out.println("Please enter your name");
				String name = sc.nextLine();
				System.out.println("Please enter your username");
				String username = sc.next();
				System.out.println("Please enter your password");
				String password = sc.next();
				String newUsername = blogServices.registration(username, password, name);
				User newUser = blogServices.getUserDetails(newUsername);
				System.out.println("PLEASE NOTE YOUR CREDENTIALS");
				System.out.println("\tUsername : "  + newUser.getUsername() );
				System.out.println("\tPassword : "  + newUser.getPassword() );
				System.out.println("\tName : "+ newUser.getName() );
				System.out.println("\tUserId : " + newUser.getUserId() + "\n");
			}else if(optionKey==2) {
				System.out.println("\t\t***********LOGIN**********");
				System.out.println("Please enter your username");
				String username = sc.next();
				System.out.println("Please enter your password");
				String password = sc.next();
				if(blogServices.signIn(username, password)!=null) {
					int signIn =1 ;
					while(signIn==1) {
					System.out.println("\t\tWelcome to blog services : " + blogServices.getUserDetails(username).getName());
					System.out.println("Please choose a suitable option");
					System.out.println("1. CREATE A NEW BLOG");
					System.out.println("2. SHOW ALL MY BLOGS");
					System.out.println("3. DELETE A BLOG");
					System.out.println("4. LOG OUT");
					switchKey = sc.nextInt();
					switch(switchKey) {
					case 1 : System.out.println("*******CREATE A BLOG*****");
							 System.out.println("PLEASE ENTER BLOG TITLE ");
							 String blogTitle = sc.nextLine();
							 System.out.println("PLEASE ENTER BLOG BODY");
							 String blogBody = sc.nextLine();
							 if(blogServices.createNewBlog(blogTitle, blogBody, username))
								 System.out.println("Your blog has been created successfully");
							 break;
					
					case 2 : System.out.println("******SHOW ALL BLOGS*****");
					
					}
					}
				}
				
			}else if(optionKey==3) {
				System.out.println("EXITING FROM BLOG SERVICES");
				flag=0;
			}else 
				System.out.println("PLEASE CHOSE A VALID OPTION");
			
			
		}
	}
}
