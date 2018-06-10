package login.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "order_name")
    private String order_name;

    @Column(name = "order_date_begin")
    private String order_date_begin;

    @Column(name = "order_date_end")
    private String order_date_end;


    private Long order_cost;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    //@JsonBackReference()
    private User user;

    @ManyToOne(targetEntity = Apart.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "apartId")
   // @JsonBackReference()
    private Apart apart;

    public Order(String order_name, String order_date_begin, String order_date_end, Long order_cost) {
        this.order_name = order_name;
        this.order_date_begin = order_date_begin;
        this.order_date_end = order_date_end;
        this.order_cost = order_cost;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_date_begin() {
        return order_date_begin;
    }

    public void setOrder_date_begin(String order_date_begin) {
        this.order_date_begin = order_date_begin;
    }

    public String getOrder_date_end() {
        return order_date_end;
    }

    public void setOrder_date_end(String order_date_end) {
        this.order_date_end = order_date_end;
    }

    public Long getOrder_cost() {
        return order_cost;
    }

    public void setOrder_cost(Long order_cost) {
        this.order_cost = order_cost;
    }

    public Apart getApart() {
        return apart;
    }

    public void setApart(Apart apart) {
        this.apart = apart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
