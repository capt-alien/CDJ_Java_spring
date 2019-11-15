package com.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.Dojo;
import com.models.Ninja;
import com.services.DojoService;
import com.services.NinjaService;



@Controller
public class DojoController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
//	SHOW DOJO INDEX
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojos", dojoService.all());
		return "ninjas/index.jsp";
	}
	
	
//	SHOW NEW DOJO TEMPLATE
	
	@RequestMapping("/dojos/new")
	public String add(Model model, @ModelAttribute("dojo") Dojo dojo) {
		model.addAttribute("dojo", dojo);
		return "/ninjas/newDojo.jsp";
	}
	
	
//	POST NEW DOJO
	@PostMapping("/dojos/new")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect: /dojos/new";
		}else {
			dojoService.add(dojo);
			return "redirect:/";
		}
	}
	
//	SHOW ONE DOJO With NINJAS

	@RequestMapping("/dojos/{id}")
	public String viewDojo(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dojoService.getOne(id);
		model.addAttribute("dojo", dojo);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("ninjas" , ninjas);
		return "ninjas/showDojo.jsp";
	}	
	
//	END
}
