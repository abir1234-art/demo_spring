package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.ClientResponseDTO;
import com.example.demo.service.ClientServices;

//import jakarta.inject.Qualifier;


@RestController
@RequestMapping("clients")

public class ClientController {
	private ClientServices clientservices;
	public ClientController(ClientServices clientservices)
	{
		this.clientservices = clientservices;
	}
	
	@GetMapping("")
	public List<ClientResponseDTO> getClient(){
		return clientservices.findAll();
		
	}
	@PostMapping("")
	public ClientResponseDTO save(@RequestBody() ClientDTO clientDTO) {
		return clientservices.save(clientDTO);
	}

		/*@Autowired
	//@Qualifier("Impl")
	private ClientServices clientservice;
*/	
}
