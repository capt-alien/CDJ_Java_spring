package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.User;
import com.services.UserService;
import com.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public MainController(UserService userService, UserValidator userValidator) {
		super();
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
//	REGESTERATION POST
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		return "index.jsp";
    	}else {
    		User u = userService.regesterUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/";
    	}
    }
	
//	LOGGIN
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	Boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}else {
    		model.addAttribute("error", "Incorrect password or username");
    		return "index.jsp";
    	}
    }
	
//	RENDER HOME
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long userId =(Long) session.getAttribute("userId");
    	User u = userService.findUserByID(userId);
    	model.addAttribute("user", u);
    	return "home.jsp";
    }
    
//	LOGOUT
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

}
