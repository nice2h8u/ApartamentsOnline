package login.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer user_id;

    @Length(min = 5,max = 20, message = "*Your login must have at least 5 or not more then 20 characters")
    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private String user_type;


    @Column(nullable = false)
    private String email;

    @OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.LAZY)
    @OrderBy
    @JsonManagedReference
    private Set<Order> orderList = new HashSet<Order>();



   public User() {

   }

    public User(String login, String hash, String user_type, String email) {
        this.login = login;
        this.hash = hash;
        this.user_type = user_type;
        this.email = email;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Set<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orderList = orderList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
