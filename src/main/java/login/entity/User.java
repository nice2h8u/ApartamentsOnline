package login.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer user_id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private Integer user_type;

    @OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.LAZY)
    @OrderBy
    @JsonManagedReference
    private Set<Order> orderList = new HashSet<Order>();

    @OneToMany(targetEntity = Apart.class, mappedBy = "user", fetch = FetchType.LAZY)
    @OrderBy
    @JsonManagedReference
    private Set<Apart> appartrList = new HashSet<Apart>();

//    public User(String login, String hash, Integer user_type) {
//        this.login = login;
//        this.hash = hash;
//        this.user_type = user_type;
//    }

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

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Set<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orderList = orderList;
    }

    public Set<Apart> getAppartrList() {
        return appartrList;
    }

    public void setAppartrList(Set<Apart> appartrList) {
        this.appartrList = appartrList;
    }


}
