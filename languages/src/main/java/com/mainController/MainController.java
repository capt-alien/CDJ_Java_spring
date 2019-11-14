package com.mainController;

import java.util.List;

import javax.validation.Valid;

import com.models.Language;
import com.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	private final LanguageService languageService;
	
	public MainController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
//	GET ALL
	@RequestMapping("/languages")
	public String index(@ModelAttribute("addNew") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);	
		return "languages/index.jsp";
	}
	

	//	NEW
//	NEW PAGE
	@RequestMapping("/language/new")
	public String newPage() {
		return "languages/new.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("addNew") Language language, BindingResult result, Model model) {
    if (result.hasErrors()) {
            List<Language> languages = languageService.allLanguages();
            model.addAttribute("languages", languages);
        return "languages/index.jsp";
    }
    else {
        languageService.addLanguage(language);
        return "redirect:/languages";
    }
    }
	
//	SHOW ONE
//	@RequestMapping("/languages/{id}")
//	public String show(@PathVariable("id") Long id, Model model) {
//		Language language = languageService.findLanguage(id);
//		model.addAttribute("Language", language);
//		return "languages/edit.jsp";
//	}
	
//	UPDATE ONE
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
	Language language = languageService.findLanguage(id);
	model.addAttribute("language", language);
	return "languages/edit.jsp";
	}
	
	
//	DELETE ONE
	@RequestMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	
	
	
	
//	END
}
