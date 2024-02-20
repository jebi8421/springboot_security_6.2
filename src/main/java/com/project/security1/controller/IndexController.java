package com.project.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.security1.model.RoleType;
import com.project.security1.model.User;
import com.project.security1.repository.UserRepository;

@Controller
public class IndexController {
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private BCryptPasswordEncoder encoder;

	@GetMapping({"","/"})
	public String index() {
		//머스테치 spring이 권장 기본폴더 src/main/resources/
		// view resolver templates (prefix), mustache (Suffix) application에서 생략가능
		return "index";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
	  return "joinForm";
	}
	
	@GetMapping("/join")
	public @ResponseBody String join() {
		return "join";
	}
	
	@PostMapping("/joinProc")
	public String joinProc(User user) {
	  user.setRole(RoleType.USER);
	  user.setPassword(encoder.encode(user.getPassword()));
	  userRepository.save(user);
	  
		return "redirect:/login";
	}
	
	@GetMapping("/test")
	public @ResponseBody String testPage() {
		return "test auth page";
	}
	
	@GetMapping("/error")
	public @ResponseBody String error() {
	  return "Error Page";
	}
}
