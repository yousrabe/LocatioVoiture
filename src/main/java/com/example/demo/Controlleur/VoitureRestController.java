package com.example.demo.Controlleur;


import com.example.demo.Dao.ISociete;
import com.example.demo.Dao.IVoiture;
import com.example.demo.Model.Response;
import com.example.demo.Model.Societe;
import com.example.demo.Model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/voiture")
public class VoitureRestController {
    @Autowired
    private IVoiture iVoiture;

    @Autowired
    private ISociete iSociete;

    @PostMapping("/add/{ids}")
    public Voiture addUser(@RequestBody Voiture u,@PathVariable Long ids ){
        u.setSociete(iSociete.getOne(ids));
        return iVoiture.save(u);

    }
    @PutMapping("/update/{ids}")
    public Voiture updateUser(@RequestBody Voiture u,@PathVariable Long ids){
        u.setSociete(iSociete.getOne(ids));
        return iVoiture.saveAndFlush(u);
    }

    @GetMapping("/allVoiture/{ids}")
    public List<Voiture> getAll(@PathVariable Long ids){
        return iVoiture.findbySociete(ids);
    }
    @GetMapping("/all")
    public List<Voiture> getAll(){
        return iVoiture.findAll();
    }
    /*
    @PostMapping("/add")
    public Voiture addUser(@RequestBody Voiture u ){
        return iVoiture.save(u);

    }
    @PutMapping("/update")
    public Voiture updateUser(@RequestBody Voiture u){
        return iVoiture.saveAndFlush(u);
    }
    */
    @DeleteMapping("/delete/{id}")
    public Response deleteUser(@PathVariable Long id){
        Response response=new Response();
        try{

            iVoiture.deleteById(id);
            response.setState("ok");
            return response;
        }
        catch(Exception e){
            response.setState("non");
            return response;}
    }

    @GetMapping("/one/{id}")
    public Voiture getUser3(@PathVariable Long id){
        return iVoiture.getOne(id);
    }

}
