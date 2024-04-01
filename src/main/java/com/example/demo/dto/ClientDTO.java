package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
	
	 private Integer id;
     private String name;
     private String lastname;
     private String mobile;
     private String email;
     private String address;
	

}
