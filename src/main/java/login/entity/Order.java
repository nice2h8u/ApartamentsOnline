package login.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Zak")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "order_name")
    private String order_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date_begin")
    private Date order_date_begin;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date_end")
    private Date order_date_end;


    private Long order_cost;

    @ManyToOne(targetEntity = Apart.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "apart_id")
    @JsonBackReference()
    private Apart apart;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference()
    private User user;



    public  Order(){

    }

    public Order(String order_name, Date order_date_begin, Date order_date_end, Long order_cost) {
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

    public Date getOrder_date_begin() {
        return order_date_begin;
    }

    public void setOrder_date_begin(Date order_date_begin) {
        this.order_date_begin = order_date_begin;
    }

    public Date getOrder_date_end() {
        return order_date_end;
    }

    public void setOrder_date_end(Date order_date_end) {
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
