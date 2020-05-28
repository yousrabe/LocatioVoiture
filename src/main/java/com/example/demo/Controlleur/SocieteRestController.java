package com.example.demo.Controlleur;

import com.example.demo.Dao.ISociete;
import com.example.demo.Model.Response;
import com.example.demo.Model.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/societe")
public class SocieteRestController {
    @Autowired
    private ISociete iSociete;

    @GetMapping("/all")
    public List<Societe> getAll(){
        return iSociete.findAll();
    }
    @PostMapping("/add")
    public Societe addSociete(@RequestBody Societe u ){
        u.setRole("societe");
        return iSociete.save(u);

    }
    @PutMapping("/update")
    public Societe updateSociete(@RequestBody Societe u){
        u.setRole("societe");
        return iSociete.saveAndFlush(u);
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteClient(@PathVariable Long id){
        Response response=new Response();
        try{

            iSociete.deleteById(id);
            response.setState("ok");
            return response;
        }
        catch(Exception e){
            response.setState("non");
            return response;}
    }
    @GetMapping("/one/{id}")
    public Societe getUser3(@PathVariable Long id){
        return iSociete.getOne(id);
    }


}
