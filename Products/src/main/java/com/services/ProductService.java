package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Product;
import com.repositories.CategoryRepo;
import com.repositories.ProductRepo;

@Service
public class ProductService {
		@Autowired
		private ProductRepo productRepo;
		@Autowired
		private CategoryRepo categoryRepo;
		public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
			this.productRepo = productRepo;
			this.categoryRepo = categoryRepo;
		}
//		CREATE
		public void addProduct(Product product) {
			productRepo.save(product);
		}
		
//		GET ALL
		public List<Product> getAll(){
			return (List<Product>) productRepo.findAll();
		}
		
//		GET ONE
		public Product getOne(Long id) {
			Optional<Product> optionalProduct = productRepo.findById(id);
			if(optionalProduct.isPresent()) {
				return optionalProduct.get();
				}else {
				return null;	
				}
		}
		
//		UPDATE
		public void update(Product product) {
			productRepo.save(product);
		}
		
//		RETURN ALL products WITH CATIGORY ID
		public Optional<Product> getAllWith(Long categoryId){
			Optional<Product> productsWithId = productRepo.findById(categoryId);
			return productsWithId;
		}
		
		
//END
}
