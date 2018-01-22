package com.example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import com.example.boot.service.UserService;
import com.example.boot.user.User;

@RestController
@RequestMapping("/prop_project")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User u)
	{
		return userService.createUser(u);
	}
	
	@PutMapping("/create/{uid}")
	public User updateMgr(@PathVariable(name="uid") Integer idd,@RequestBody User u)
	{
		return userService.updateMgr(idd,u);
		
	}
	@GetMapping("/user/{mgr_id}")
	public List<User> userUnder(@PathVariable(name="mgr_id") Integer idd)
	{
		return userService.underUser(idd);
	}
	
	@GetMapping("/mgr/{uid}")
	public List<User> getMgr(@PathVariable(name="uid") Integer uuid)
	{
		return userService.getMgr(uuid);
	}
	
	//localhost:8080/email/user
	@GetMapping("/email/{pre}")
	public List<User> getEmailPrefix(@PathVariable String pre)
	{
		System.out.println(pre);
		return userService.getEmailPrefix(pre);
	}
	
	//localhost:8080/email?prefix="user"
/*	@GetMapping("/email")
	public List<User> getEmailPrefix(@RequestParam(name="pre") String pre)
	{
		return userService.getEmailPrefix(pre);
	}
	*/

}
