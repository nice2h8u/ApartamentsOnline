package login.rest;


import login.classes.LoginService;
import login.entity.User;

import login.rest.Entity.FilterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration/")
public class RegistrationRest {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<Object>
    public void createNewUser(@RequestBody FilterUser user) {
        System.out.println(user.getLogin());
        System.out.println(user.getHash());
        System.out.println(user.getEmail());
        User userExists = loginService.findUserByEmail(user.getEmail());
        if (userExists != null)
           System.out.println("exists");
      //      return ResponseEntity.ok("user exists");
      else{
         userExists = new User(user.getLogin(),user.getHash(),"USER",user.getEmail());
        System.out.println("end");
        loginService.saveUser(userExists);}
       // return ResponseEntity.ok(loginService.saveUser(userExists));

    }


}
