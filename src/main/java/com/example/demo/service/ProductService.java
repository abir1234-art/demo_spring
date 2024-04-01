package com.example.demo.service;
import  com.example.demo.dto.ProductDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.demo.models.Product;
@Service
public class ProductService {
	// List<ProductDTO> getAllProducts();

	   // ProductDTO createProduct(ProductDTO productDTO);

	   // ProductDTO updateProduct(Long productId, ProductDTO productDTO);

	    //void deleteProduct(Long productId);
	

	    private final ProductRepository productRepository;

	    @Autowired
	    public ProductService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    public List<Product> findAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product createProduct(Product product) {
	        // Here you can add any business logic before saving the product
	        return productRepository.save(product);
	    }

	    public Product updateProduct(Long id, Product productDetails) {
	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
	        product.setName(productDetails.getName());
	        product.setDescription(productDetails.getDescription());
	        product.setCategory(productDetails.getCategory());
	        product.setPrice(productDetails.getPrice());
	        product.setAvailableQuantity(productDetails.getAvailableQuantity());
	        // Add more fields as necessary

	        return productRepository.save(product);
	    }

	    public void deleteProduct(Long id) {
	        Product product = productRepository.findById(id)
	                .orElseThrow();}


}

