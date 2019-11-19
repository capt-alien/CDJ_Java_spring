package com.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.Show;
import com.models.User;
import com.repositories.ShowRepo;
import com.repositories.UserRepo;
import com.services.ShowService;
import com.services.UserService;
import com.validator.UserValidator;

@Controller
public class MainController {
	private final ShowRepo showRepo;
	private final UserRepo userRepo;
	private final UserService userService;
	private final ShowService showService;
    private final UserValidator userValidator;
        




public MainController(ShowRepo showRepo, UserRepo userRepo, UserService userService, ShowService showService,
			UserValidator userValidator) {
		super();
		this.showRepo = showRepo;
		this.userRepo = userRepo;
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
    
    
//	@PostMapping("/new")
//	public String createMoviePost(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, HttpSession session) {
//		if(result.hasErrors()) {
//			return "new.jsp";
//		} else {
//			User u = userService.findUserById((Long) session.getAttribute("userId"));
//			movie.setCreator(u);
//			Movie m = movieRepository.save(movie);
//			return "redirect:/home";
//		}
//	}
    
   
//  RENDER NEW
    @GetMapping("/new")
    public String newShowForm(@ModelAttribute("show") Show show) {
    	return "newShow.jsp";
    }  
//    SAVE NEW
    @PostMapping("/new")
    public String postNewShow(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "new.jsp";
    	}else {
    		Show s = showRepo.save(show);
    		return "redirect:/home";
    	}
    }
    
//    RENDER ONE SHOW
    
//  RENDER EDIT SHOW
    
//    SAVE EDIT
    
    
//    DELETE ROUTE
    

}
