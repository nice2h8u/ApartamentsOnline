package login.classes;

import login.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class Login extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private User user;

    public Login(User user) {
        super(user.getLogin(), user.getHash(), AuthorityUtils.createAuthorityList("ALL"));
        this.user = user;
    }

}
