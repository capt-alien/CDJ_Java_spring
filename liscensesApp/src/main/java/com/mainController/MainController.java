package com.mainController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.License;
import com.models.User;
import com.services.LicenseService;
import com.services.UserService;



@Controller
public class MainController {
	private final UserService userService;
	private final LicenseService licenseService;
	
	public MainController(UserService userService, LicenseService licenseService) {
		this.userService = userService;
		this.licenseService = licenseService;
	}
//SHOW ALL USERS
	@RequestMapping("/")
	public String index(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "/license/index.jsp";
	}
	
//	RENDER NEW PERSON TEMPLATE
	
	@RequestMapping("/persons/new")
	public String showAddUser(@ModelAttribute("user") User user) {
		return "/license/newPerson.jsp";
	}
//	POST NEW PERSON
	
//	@RequestMapping("/persons/new")
//	public String AddUser(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes errors) {
//		if(result.hasErrors()) {
//			errors.addFlashAttribute("errors", result.getAllErrors());
//			return "redirect:/persons/new";
//		}else {
//			userService.addUser(user);
//			return "redirect:/";
//		}
//	}
	
//	RENDER NEW LICENSE
	
//	@RequestMapping("/licenses/new")
//	public String showAddLicense(Model model, @ModelAttribute("license") License license) {
//		List<User> users = userService.getAllUsers();
//		model.addAttribute("users", users);
//		return "/license/newLicense.jsp";
//	}
	
//	POST NEW LICENSE
	
//	@RequestMapping("/licenses/new")
//	public String addLicense(@Valid @ModelAttribute("license") License license,
//								BindingResult result,
//								RedirectAttributes errors) {
//		System.out.println(license.getExpiration_date());
//		if(result.hasErrors()) {
//			errors.addFlashAttribute("errors", result.getAllErrors());
//			return "redirect:/licenses/new";
//		}else {
//			licenseService.addLicense(license);
//			return "redirect:/";
//		}
//	}
	
	
//	SHOW ONE PERSON
	
//	@RequestMapping("/persons/{id}")
//	public String ShowOneUserLicense(Model model, @PathVariable("id") Long id) {
//		Optional<User> user = userService.getUserById(id);
//		if(user ==null) {
//			return "redirect:/";
//		}else {
//		model.addAttribute("user", user);
//		return "/license/show.jsp";
//	}
//	}
	
//	DELETE ONE PERSON
	
//	@RequestMapping("persons/{userId}/delete")
//	public String deleteUser(@PathVariable("userID") Long userId) {
//		userService.deleteUser(userId);
//		return "redirect:/";
//	}
	
//	END CLASS
}
