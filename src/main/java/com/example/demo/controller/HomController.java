package com.example.demo.controller;

import com.example.demo.dao.StudentJpaRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Course;
import com.example.demo.model.StdCourse;
import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomController {
	
	@Autowired
	StudentJpaRepository studentRepository;
	
	public void testManyToMany()
	{
		Student st1 = new Student();
		st1.setName("Student1");
		
		Student st2 = new Student();
		st2.setName("Student2");
		
		StdCourse c1 = new StdCourse();
		c1.setName( "Course 1");
		
		StdCourse c2 = new StdCourse();
		c2.setName( "Course 2");
		
		HashSet<StdCourse> courses = new HashSet<StdCourse>();
		courses.add(c1);
		courses.add(c2);
		
		st1.setCourses(courses);
		
		st2.setCourses(courses);
		
		this.studentRepository.save(st1);
		this.studentRepository.save(st2);
		
	}
	@GetMapping("/")
	String home(Model model){
		
		model.addAttribute("message", "Hello World");
		
		System.out.println("Home Controller");
		//testManyToMany();
		return "home";
	}
	/*
	@GetMapping("/user")
	String user(Model model){
		
		User user = new User();
		user.setName("TK");
		user.setEmail("myemail@gmail.com");
		model.addAttribute("user", user);
		
		System.out.println("User Controller");
		return "user";
	}
	*/
	@GetMapping("/users")
	String userList(Model model){
		
		List<UserDto> users = new ArrayList<UserDto>();
		UserDto user = new UserDto();
		user.setName("User one");
		user.setEmail("userone@gmail.com");
		
		users.add(user);
		
		UserDto user1 = new UserDto();
		user1.setName("User 1");
		user1.setEmail("user2@gmail.com");
		
		users.add(user1);
		
		model.addAttribute("users", users);
		
		System.out.println("User List Controller");
		return "users";
	}
}
