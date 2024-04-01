package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientDAO;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.ClientResponseDTO;
import com.example.demo.models.ClientEntity;

import javassist.NotFoundException;

@Service
public abstract class ClientServiceImpl implements ClientServices {

    private final ClientDAO clientdao;
    private final ModelMapper modelmapper;

    public ClientServiceImpl(ClientDAO clientdao, ModelMapper modelmapper) {
        this.clientdao = clientdao;
        this.modelmapper = modelmapper;
    }

    @Override
    public ClientResponseDTO save(ClientDTO clientrequest) {
        ClientEntity cliententity = modelmapper.map(clientrequest, ClientEntity.class);
        ClientEntity saved = clientdao.save(cliententity); // Correction here
        return modelmapper.map(saved, ClientResponseDTO.class);
    }

    public ClientResponseDTO findById(Integer id) {
        ClientEntity cliententity = clientdao.findById(id).orElseThrow(() -> new RuntimeException("Client not found")); 
        return modelmapper.map(cliententity, ClientResponseDTO.class);
    }

  /*  @Override
    public ClientResponseDTO findByNom(String name) {
        ClientEntity cliententity = ((Optional<ClientEntity>) clientdao.findByNom(name)).orElseThrow(() -> new RuntimeException("Client not found"));
        return modelmapper.map(cliententity, ClientResponseDTO.class);
    }*/

    @Override
    public void delete(Integer id) {
        if (clientdao.existsById(id)) {
            clientdao.deleteById(id);
        } else {
            throw new RuntimeException("Client not found"); 
        }
    }

    @Override
    public ClientResponseDTO update(ClientDTO clientdto, Integer id) throws NotFoundException {
        ClientEntity cliententity = clientdao.findById(id).orElseThrow(() -> new NotFoundException("Client Not found"));
        modelmapper.map(clientdto, cliententity);
        ClientEntity updated = clientdao.save(cliententity);
        return modelmapper.map(updated, ClientResponseDTO.class);
    }

   /* @Override
    public List<ClientEntity> findAll() {
        return clientdao.findAll().stream().map(el -> modelmapper.map(el, ClientDTO.class)).collect(Collectors.toList());
    }*/
}
