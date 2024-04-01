package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.ClientDTO;
import com.example.demo.models.ClientEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public abstract class ClientDAO implements JpaRepository<ClientEntity, Integer> {

	public abstract ClientEntity findByNom(String nom);

	public abstract ClientEntity save(ClientEntity cliententity);
	public abstract Optional<ClientEntity> findById(Integer id);

	public abstract void deleteById(Integer id);

	public abstract  List<ClientEntity> findAll();
}
