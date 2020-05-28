package com.example.demo.Controlleur;

import com.example.demo.Dao.IClient;
import com.example.demo.Dao.IReclamation;
import com.example.demo.Model.Mail;
import com.example.demo.Model.Reclamation;
import com.example.demo.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/reclamation")
public class ReclamationRestController {
    @Autowired
    private IReclamation iReclamation;
    //*****************************
    @Autowired
    private IClient iClient;

    @Autowired
    private MailService mailService;

    @GetMapping("/allClient/{idC}")
    public List<Reclamation> getClient (@PathVariable Long idC){
        return  iReclamation.findbyClient(idC);
    }
    //******************************
    @GetMapping("/all")
    public List<Reclamation> getAll(){
        return iReclamation.findAll();
    }


    @PostMapping("/add/{idC}")
    public Reclamation addReclamation(@RequestBody Reclamation r,@PathVariable Long idC){
        r.setClient(iClient.getOne(idC));
        return iReclamation.save(r);
    }


    @PutMapping("/update/{idC}")
    public Reclamation updateReclamation(@RequestBody Reclamation r,@PathVariable Long idC){
        r.setClient(iClient.getOne(idC));

        return iReclamation.saveAndFlush(r);

    }


    @DeleteMapping("/delete/{id}")
    public Response deleteReclamation(@PathVariable Long id){
        Response response=new Response();
        try{

            iReclamation.deleteById(id);
            response.setState("ok");
            return response;
        }
        catch(Exception e){
            response.setState("non");
            return response;}
    }


    @GetMapping("/one/{id}")
    public Reclamation getReclamation(@PathVariable Long id){
        return iReclamation.getOne(id);
    }

    @RequestMapping(value="/sendMail",method= RequestMethod.POST)
    public Response sendMail(@RequestBody Mail mail){
        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

        Response reponse = new Response();
        try{
        mail.setFrom("wissal.mahdouani@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject("Réponse de reclamation");

        mail.setContent(mail.getContent());

        mailService.sendSimpleMessage(mail);
        reponse.setState("ok");
        return reponse;
    }

        catch(Exception e){
            reponse.setState("non");
            return reponse;}


    }}
