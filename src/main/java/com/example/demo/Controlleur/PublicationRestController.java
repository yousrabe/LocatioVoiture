package com.example.demo.Controlleur;

import com.example.demo.Dao.IPublication;
import com.example.demo.Dao.ISociete;
import com.example.demo.Dao.IVoiture;
import com.example.demo.Model.Publication;
import com.example.demo.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/publication")
public class PublicationRestController {
    @Autowired
    private IPublication iPublication;
    //******************************
    @Autowired
    private IVoiture iVoiture;





    @GetMapping("/allpublication/{idV}")
    public List<Publication> getVoiture (@PathVariable Long idV){
        return  iPublication.findbyVoiture(idV);
    }

    @PostMapping("/add/{idV}")
    public Publication addPublication(@RequestBody Publication u,@PathVariable Long idV ){
        u.setVoiture(iVoiture.getOne(idV));
        return iPublication.save(u);

    }
    @PutMapping("/update/{idV}")
    public Publication updatePublication(@RequestBody Publication u,@PathVariable Long idV ){
        u.setVoiture(iVoiture.getOne(idV));
        return iPublication.saveAndFlush(u);
    }




    //*****************************
    @GetMapping("/all")
    public List<Publication> getAll(){
        return iPublication.findAll();
    }
    /*
    @PostMapping("/add")
    public Publication addUser(@RequestBody Publication u ){
        return iPublication.save(u);

    }
    @PutMapping("/update")
    public Publication updateUser(@RequestBody Publication u){
        return iPublication.saveAndFlush(u);
    }
    */
    @DeleteMapping("/delete/{id}")
    public Response deleteUser(@PathVariable Long id){
        Response response=new Response();
        try{

            iPublication.deleteById(id);
            response.setState("ok");
            return response;
        }
        catch(Exception e){
            response.setState("non");
            return response;}
    }
    @GetMapping("/one/{id}")
    public Publication getUser3(@PathVariable Long id){
        return iPublication.getOne(id);
    }


//***************************



}
