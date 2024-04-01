package com.example.demo.models;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable = false)
	    private String name;
	    @Column(nullable = false)
	    private String description;
	    @Column(nullable = false)
	    private String category;
	    @Column(nullable = false)
	    private int availableQuantity;
	    @Column(nullable = false)
	    private double price;
	    @Column(nullable = false)
	    private Date creationDate;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getAvailableQuantity() {
			return availableQuantity;
		}
		public void setAvailableQuantity(int availableQuantity) {
			this.availableQuantity = availableQuantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		

	    // Getters and setters
	}


