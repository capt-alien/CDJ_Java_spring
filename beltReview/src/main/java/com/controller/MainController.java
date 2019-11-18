package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.Event;
import com.models.User;
import com.services.EventService;
import com.services.UserService;
import com.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final EventService eventService;

	
	public MainController(UserService userService, UserValidator userValidator, EventService eventService) {
		super();
		this.userService = userService;
		this.eventService = eventService;
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
    public String home(HttpSession session, Model model, @ModelAttribute("event")Event event) {
    	Long userId =(Long) session.getAttribute("userId");
    	
    	User u = userService.findUserByID(userId);
    	model.addAttribute("user", u);
    	List<Event> userLocationEvents = getUserLocationEvents(u.getState());
    	model.addAttribute("userLoactionEvents", userLocationEvents);
    	List<Event> outOfStateEvents = getAllEventsOtherThanUserLocation(u.getState());
    	model.addAttribute("outOfStateEvents", outOfStateEvents);
    	return "home.jsp";
    }
    
//	LOGOUT
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

//    RENDER NEW PAGE
	@RequestMapping("/new")
	public String newEvent(@ModelAttribute("event")Event event) {
		return "new.jsp";
	}
    
//	POST NEW EVENT
    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String postEvent(@Valid @ModelAttribute("event")Event event, BindingResult result,HttpSession session, Model model) {
    	if(result.hasErrors()) {
    		System.out.println("*******TEST HAS ERROR********");
    		Long user_id = (Long) session.getAttribute("user");
	    	User user = userService.findUserByID(user_id);
//	    	List sameLocationEvents = getUserLocationEvents(user.getState());
	    	model.addAttribute("user", user);
    		return "new.jsp";

    	}else {
    		System.out.println("*******TEST HAS NO ERROR********");
    		Event newEvent = eventService.createEvent(event);
    		Long userID = (Long) session.getAttribute("user");
    		User user = userService.findUserByID(userID);
    		newEvent.setHost(user);
    		eventService.updateEvent(newEvent);
    		return "redirect:/home";
    	}
    }

    
    
    List<Event> getUserLocationEvents(String state){
    	List<Event> sameLocationEvents = eventService.findEventByState(state);
    	return sameLocationEvents;
    }
    
    List<Event> getAllEventsOtherThanUserLocation(String state){
    	List<Event> allEvents = eventService.findAllEvents();
    	List<Event> sameLocationEvents = eventService.findEventByState(state);
    	allEvents.removeAll(sameLocationEvents);
    	return allEvents;
    }
    
}
