package com.example.demo.Controlleur;

import com.example.demo.Dao.IClient;
import com.example.demo.Model.Client;
import com.example.demo.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientRestController {
    @Autowired
    private IClient iClient;


    @GetMapping("/all")
    public List<Client> getAll(){
        return iClient.findAll();
    }
    @PostMapping("/add")
    public Client addClient(@RequestBody Client u ){
        u.setRole("client");
        return iClient.save(u);

    }
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client u){
        u.setRole("client");
        return iClient.saveAndFlush(u);
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteClient(@PathVariable Long id){
        Response response=new Response();
        try{

            iClient.deleteById(id);
            response.setState("ok");
            return response;
        }
        catch(Exception e){
            response.setState("non");
            return response;}
    }
    @GetMapping("/one/{id}")
    public Client getUser3(@PathVariable Long id){
        return iClient.getOne(id);
    }


}
