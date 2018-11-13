package login.classes;

import login.repository.UserRepository;
import login.entity.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class LoginServiceImpl implements LoginService {


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User login = userRepository.findByLogin(string);
        if (login == null) {
            throw new UsernameNotFoundException("user not found");
       }
        return new Login(login);
    }

    public User findUserByEmail(String email) {
        User login = userRepository.findByEmail(email);
        return login;
    }


    public User saveUser(User user){

        return    userRepository.save(new User(user.getLogin(),bCryptPasswordEncoder.encode(user.getHash()),
                "USER",user.getEmail()));
    }





}
