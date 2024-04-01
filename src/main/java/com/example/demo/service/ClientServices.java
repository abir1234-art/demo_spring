package com.example.demo.service;
import com.example.demo.dto.ClientDTO;

import java.util.List;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.ClientResponseDTO;

import javassist.NotFoundException;

public interface ClientServices {
	ClientResponseDTO save(ClientDTO clientrequest);

	ClientResponseDTO finbyId(Integer id);
	
	ClientResponseDTO findByNom(String name);
	
	void delete(Integer id);
	
	ClientResponseDTO update(ClientDTO clientrequest, Integer id) throws NotFoundException;
	List<ClientResponseDTO> findAll();
	
}
