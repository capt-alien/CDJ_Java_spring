package com.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.Category;
import com.models.Product;
import com.services.CategoryService;
import com.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductsController(ProductService productService, CategoryService categoryService) {
		super();
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
//	ROUTES
//	GET NEW
	@RequestMapping("/new")
	public String newProduct(Model model, 
							@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
//	POST NEW
	@PostMapping("/new")
	public String add(@Valid @ModelAttribute("product") Product product, 
						BindingResult result, 
						RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/products/new";
		}else {
			productService.addProduct(product);
			return "redirect:/";
		}
	}
	
//	SHOW ONE
	@RequestMapping("/{id}")
	public String showCat(Model model, @PathVariable("id") Long id) {
		Product product = productService.getOne(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getAllExceptId(id));
		return "showProduct.jsp";
	}
	
	
//	EDIT ONE
	@PostMapping("/{id}")
	public String addProduct(@PathVariable("id") Long productId, @RequestParam("category") Long categoryId) {
		Product product = productService.getOne(productId);
		Category category = categoryService.getOne(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		productService.update(product);
		return "redirect:/products/"+productId;
	}	

//END CONTROLLER
}
