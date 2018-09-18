package login.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private  LoginService userService;

    @Autowired
    public UserDetailsServiceImpl(LoginService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDetails details = userService.loadUserByUsername(login);
        if (details != null) {
            return details;
        } else {
            throw new UsernameNotFoundException("Invalid user " + login);
        }
    }



}
