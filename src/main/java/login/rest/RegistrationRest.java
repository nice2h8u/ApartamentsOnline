package login.rest;


import login.classes.LoginService;
import login.entity.User;

import login.rest.Entity.FilterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/registration/")
public class RegistrationRest {

    @Autowired
    LoginService loginService;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

    public void createNewUser(@RequestBody FilterUser user,HttpServletRequest request) {
        System.out.println(user.getLogin());
        System.out.println(user.getHash());
        System.out.println(user.getEmail());
        User userExists = loginService.findUserByEmail(user.getEmail());
        if (userExists != null)
           System.out.println("exists");

      else{
         userExists = new User(user.getLogin(),user.getHash(),"USER",user.getEmail());
        System.out.println("end");
        loginService.saveUser(userExists);
        authenticateUserAndSetSession(userExists, request);
      }


    }

    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getLogin();
        String password = user.getHash();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        // generate session if one doesn't exist
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }


}
