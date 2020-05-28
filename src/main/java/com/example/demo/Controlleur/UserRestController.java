package com.example.demo.Controlleur;

import com.example.demo.Dao.IUser;
import com.example.demo.Model.Response;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private IUser iUser;

    @GetMapping("/all")
    public List<User> getAll(){
        return iUser.findAll();
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User u ){
        u.setRole("admin");
        return iUser.save(u);

    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User u){
        u.setRole("admin");
        return iUser.saveAndFlush(u);
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteUser(@PathVariable Long id){
        Response response=new Response();
        try{

            iUser.deleteById(id);
            response.setState("ok");
            return response;
        }
        catch(Exception e){
            response.setState("non");
            return response;}
    }
    @GetMapping("/one")
    public User getUser(Long id){
        return iUser.getOne(id);
    }
    @GetMapping("/one2")
    public User getUser2(@RequestParam Long id){
        return iUser.getOne(id);
    }
    //la plus utilisée
    @GetMapping("/one3/{id}")
    public User getUser3(@PathVariable Long id){
        return iUser.getOne(id);
    }
    @GetMapping("/login/{login}/{mp}")
    public User login1(@PathVariable String login,@PathVariable String mp)
    {
        return iUser.login(login,mp);

    }
    @PostMapping("/login")
    public HashMap<String,User> login(@RequestBody User user )
    {   HashMap<String,User> h= new HashMap<>();

        try {
            h.put("data",iUser.login(user.getLogin(),user.getMp()));

        }
        catch (Exception e){
            h.put("data",null);
        }
         return  h;
    }
}
