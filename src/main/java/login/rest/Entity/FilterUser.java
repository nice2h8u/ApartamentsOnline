package login.rest.Entity;

public class FilterUser
{

        private String login;
        private String hash;
        private  String email;

        FilterUser(){

        }

        public FilterUser(String login, String hash, String email) {
            this.login = login;
            this.hash = hash;
            this.email = email;

        }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
