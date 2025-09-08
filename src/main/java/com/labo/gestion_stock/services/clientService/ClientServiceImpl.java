package com.labo.gestion_stock.services.clientService;

import com.labo.gestion_stock.dtoEntity.clientDTO.ClientConnectDto;
import com.labo.gestion_stock.dtoEntity.clientDTO.ClientRequestDTO;
import com.labo.gestion_stock.dtoEntity.clientDTO.ClientResponseDTO;
import com.labo.gestion_stock.entities.Client;
import com.labo.gestion_stock.entities.Commande;
import com.labo.gestion_stock.entities.User;
import com.labo.gestion_stock.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ClientResponseDTO create(ClientRequestDTO client) {
        Client client1 = modelMapper.map(client,Client.class);
        User user = userRepository.save(client1);
        ClientResponseDTO clientResponseDTO=modelMapper.map(user,ClientResponseDTO.class);
        return clientResponseDTO;
    }

    @Override
    public List<ClientResponseDTO> getAll() {
        List<ClientResponseDTO> clientResponeDTOS = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for (User user:users){
            if (user instanceof Client){
                clientResponeDTOS.add(modelMapper.map(user,ClientResponseDTO.class));
            }
        }
        return clientResponeDTOS;
    }

    @Override
    public Optional<ClientResponseDTO> getUserById(long id){
        User user =userRepository.findById(id).orElse(null);
        if(user!=null){
            return Optional.of(new ClientResponseDTO(
                    user.getId_user(),
                    user.getNameUser(),
                    user.getEmail(),
                    user.getNumTel(),
                    ((Client) user).getMatricule()
            ));
        }
        return null;
    }

    @Override
    public void deleteById(long id){
        Client client = (Client) userRepository.findById(id).get();
        if(client == null){
            throw new RuntimeException("client inexistant : supression impossible");
        }
        List<Commande> commandes = client.getCommandes();
        for (Commande commande : commandes){
            commande.setUser(null);
        }
        userRepository.deleteById(id);
    }

    @Override
    public boolean exisById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean connecter(ClientConnectDto connectDto) {
        User user = userRepository.findUserByNameUserAndPassword(connectDto.getUserName(),connectDto.getPassword());
        if(user!=null){
            return true;
        }
        return false;
    }

    @Override
    public String getEmailUser(String email) {
       return userRepository.getEmail(email);
    }

    @Override
    public User getUser(String name) {
        return userRepository.getUser(name);
    }
}
