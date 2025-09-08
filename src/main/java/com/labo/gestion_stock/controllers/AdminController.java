package com.labo.gestion_stock.controllers;


import com.labo.gestion_stock.services.clientService.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/API/user")
public class AdminController {

    private ClientService userService;

    public AdminController(ClientService userService){
        this.userService = userService;
    }


//    @PostMapping("/admin/create")
//    public ResponseEntity<User> createAdmin(@RequestBody Admin admin){
//        User user = userService.create(admin);
//        return ResponseEntity.ok(user);
//    }

//    @GetMapping("/admin/")
//    public List<User> getAll(){
//        return userService.getAll().stream().filter(user -> user instanceof Admin).toList();
//    }

//    @GetMapping("/admin/{id}")
//    public Optional<ClientResponseDTO> getUserById(@PathVariable long id){
//        Optional<ClientResponseDTO> user = userService.getUserById(id);
//        return user;
//    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        userService.deleteById(id);
        return ResponseEntity.ok("supprimé avec succès");
    }
}

