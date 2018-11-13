package login.classes;

import login.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService {

    public User findUserByEmail(String email);
    public User saveUser(User user);
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException;

}
