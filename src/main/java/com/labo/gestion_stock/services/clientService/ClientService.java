package com.labo.gestion_stock.services.clientService;

import com.labo.gestion_stock.dtoEntity.clientDTO.ClientConnectDto;
import com.labo.gestion_stock.dtoEntity.clientDTO.ClientRequestDTO;
import com.labo.gestion_stock.dtoEntity.clientDTO.ClientResponseDTO;
import com.labo.gestion_stock.entities.User;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientResponseDTO  create(ClientRequestDTO clientDTO);
    List<ClientResponseDTO> getAll();
    Optional<ClientResponseDTO> getUserById(long id);
    void deleteById(long id);
    boolean exisById(long id);
    boolean connecter(ClientConnectDto clientConnectDto);
    String getEmailUser(String email);
    User getUser(String name);
}
