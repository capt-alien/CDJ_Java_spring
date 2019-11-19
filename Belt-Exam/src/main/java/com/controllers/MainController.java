package com.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.Show;
import com.models.User;
import com.repositories.ShowRepo;
import com.services.ShowService;
import com.services.UserService;
import com.validator.UserValidator;

@Controller
public class MainController {
	private final ShowRepo showRepo;
	private final UserService userService;
	private final ShowService showService;
    private final UserValidator userValidator;
        
    
public MainController(ShowRepo showRepo, UserService userService, ShowService showService,
			UserValidator userValidator) {
		super();
		this.showRepo = showRepo;
		this.userService = userService;
		this.showService = showService;
		this.userValidator = userValidator;
	}

//    RENDER INDEX PAGE
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "index.jsp";
    }
    
//    POST NEW USER
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		return "index.jsp";
    	}else {
    		User u = userService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/";
    	}
    }
    
//    LOGGIN
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		Boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		// else, add error messages and return the login page
		}else {
			model.addAttribute("error", "Incorrect password or username");
			return "loginPage.jsp";
		}
	}
    
//  LOGGOUT
	  @RequestMapping("/logout")
	  public String logout(HttpSession session) {
	  	session.invalidate();
	  	return "redirect:/";
	  } 
    
//    RENDER HOME
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	List<Show> shows = showService.findall();
    	model.addAttribute("shows", shows);
    	Long userId =(Long) session.getAttribute("userId");
    	User u = userService.findUserById(userId);
    	model.addAttribute("user", u);
    	return "home.jsp";
    }
   
//  RENDER NEW
    @GetMapping("/new")
    public String newShowForm(@ModelAttribute("show") Show show) {
    	return "newShow.jsp";
    }  
//    SAVE NEW
    @PostMapping("/new")
    public String postNewShow(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "newShow.jsp";
    	}else {
    		Show s = showRepo.save(show);
    		return "redirect:/home";
    	}
    }
    
//    RENDER ONE SHOW
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Show s = showService.findShowById(id);
    	model.addAttribute("show", s);
    	return "show.jsp";
    }
    
  
//  RENDER EDIT SHOW
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Show s = showService.findShowById(id);
    	model.addAttribute("show", s);
    	return "edit.jsp";
    }
  
//    SAVE EDIT
    @PostMapping("/edit/{id}")
    public String commitEdits(@PathVariable("id") Long id, @Valid @ModelAttribute("show") Show show, BindingResult result ) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}else {
    		showRepo.save(show);
    		return "redirect:/home";
    	}
    }
    
//    DELETE ROUTE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
    	showRepo.deleteById(id);
    	return "redirect:/home";
    }
}
