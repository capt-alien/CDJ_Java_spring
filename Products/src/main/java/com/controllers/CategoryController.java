package com.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/")
public class CategoryController {
		@Autowired
		private final CategoryService categoryService;
		private final ProductService productService;
		public CategoryController(CategoryService categoryService, ProductService productService) {
			super();
			this.categoryService = categoryService;
			this.productService = productService;
		}
		@RequestMapping("")
		public String index(Model model) {
			model.addAttribute("categories", categoryService.getAll());
			model.addAttribute("products", productService.getAll());
			return "index.jsp";
		}
//		NEW CAT FORM
		@RequestMapping("/categories/new")
		public String newCategory(Model model, @ModelAttribute("category") Category category) {
			return "newCategory.jsp";
		}
//		POST NEW CAT
		@PostMapping("/categories/new")
		public String add(@Valid @ModelAttribute("category") Category category, BindingResult result, RedirectAttributes errors) {
			if(result.hasErrors()) {
				errors.addFlashAttribute("errors", result.getAllErrors());
				return "redirect:/products/new";
			}else {
				categoryService.addCategory(category);
				return "redirect:/";
			}
		}
//		SHOW ONE CATEGORY
		@RequestMapping("/categories/{id}")
		public String showCat(Model model, @PathVariable("id") Long id) {
			Category category = categoryService.getOne(id);
			model.addAttribute("category", category);
			model.addAttribute("products", productService.getAllExceptId(id));
			return "showCategory.jsp";
		}
		
		
//		POST EDIT
		@PostMapping("/categories/{id}")
		public String addProduct(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
			Category category = categoryService.getOne(categoryId);
			Product product = productService.getOne(productId);
			List<Product> products = category.getProducts();
			products.add(product);
			categoryService.update(category);
			return "redirect:/categories/"+categoryId;
		}
//		END CONTROLLER
}
