package com.example.demo.Controlleur;

import com.example.demo.Dao.IClient;
import com.example.demo.Dao.IPublication;
import com.example.demo.Dao.IReservation;
import com.example.demo.Model.Reservation;
import com.example.demo.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/reservation")
public class ReservationRestController {
    @Autowired
    private IReservation iReservation;
    //*******************************
    @Autowired
    private IClient iClient;
    @Autowired
    private IPublication iPublication;






    //*******************************
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return iReservation.findAll();
    }
    @GetMapping("/allClient/{idc}")
    public List<Reservation> getAllByclient(@PathVariable Long idc){
        return iReservation.findbyReservationClient(idc);
    }
    @GetMapping("/allpublication/{idp}")
    public List<Reservation> getAllByPub(@PathVariable Long idp){
        return iReservation.findbyReservationPublication(idp);
    }

    @PostMapping("/add/{idc}/{idp}")
    public Reservation addReservation(@RequestBody Reservation u,@PathVariable Long idc,@PathVariable Long idp ){
        u.setClient(iClient.getOne(idc));
        u.setPublication(iPublication.getOne(idp));
        return iReservation.save(u);

    }
    @PutMapping("/update/{idc}/{idp}")
    public Reservation updateReservation(@RequestBody Reservation u,@PathVariable Long idc,@PathVariable Long idp){
        u.setClient(iClient.getOne(idc));
        u.setPublication(iPublication.getOne(idp));
        return iReservation.saveAndFlush(u);
    }

    /**
    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation u ){
        return iReservation.save(u);

    }


    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation u){
        return iReservation.saveAndFlush(u);
    }
    **/

    @DeleteMapping("/delete/{id}")
    public Response deleteReservation(@PathVariable Long id){
        Response response=new Response();
        try{

            iReservation.deleteById(id);
            response.setState("ok");
            return response;
        }
        catch(Exception e){
            response.setState("non");
            return response;}
    }
    @GetMapping("/one/{id}")
    public Reservation getReservation(@PathVariable Long id){
        return iReservation.getOne(id);
    }



}
