package com.labo.gestion_stock.controllers;



import com.labo.gestion_stock.dtoEntity.clientDTO.ClientConnectDto;
import com.labo.gestion_stock.dtoEntity.clientDTO.ClientRequestDTO;
import com.labo.gestion_stock.dtoEntity.clientDTO.ClientResponseDTO;
import com.labo.gestion_stock.entities.User;
import com.labo.gestion_stock.services.clientService.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/API/user")
public class ClientController {

    private ClientService userService;

    public ClientController(ClientService userService){
        this.userService = userService;
    }

    @PostMapping("/client/create")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO client){
        return ResponseEntity.ok(userService.create(client));
    }


    @GetMapping("/client/")
    public List<ClientResponseDTO> getAll(){
        return userService.getAll();
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientResponseDTO> getUserById(@PathVariable long id){
        Optional<ClientResponseDTO> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    @DeleteMapping("/client/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        if (userService.exisById(id)){
            userService.deleteById(id);
            return ResponseEntity.ok("supprimé avec succès");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/connect")
    public ResponseEntity<String> connection(@RequestBody ClientConnectDto connectDto){
        if (userService.connecter(connectDto)){
           return ResponseEntity.ok("connection reussi");
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<String> getEmail(@PathVariable String email){
        String emailUser = userService.getEmailUser(email);
        return ResponseEntity.ok(emailUser);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name){
        return ResponseEntity.ok(userService.getUser(name));
    }
}
