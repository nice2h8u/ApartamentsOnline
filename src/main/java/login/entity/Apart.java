package login.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Apart")
public class Apart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apartId")
    private Integer apartId;

    @Column(name = "apart_name", nullable = false, length = 150)
    private String apart_name;

    @Column(name = "apart_city", nullable = false, length = 40)
    private String apart_city;

    @Column(name = "apart_address", nullable = false, length = 150)
    private String apart_address;

    @Column(name = "apart_phone", nullable = false, length = 11)
    private String apart_phone;

    @Column(name = "apart_x", nullable = false)
    private String apart_x;

    @Column(name = "apart_y", nullable = false)
    private String apart_y;
    @Column(name = "apart_cost", nullable = false)
    private Integer apart_cost;

    @Column(name = "apart_description", nullable = false)
    private String apart_description;

    @OneToMany(targetEntity = Order.class, mappedBy = "apart", fetch = FetchType.LAZY) //mapped - имя поля в ордерс
    @OrderBy
    @JsonManagedReference
    private Set<Order> orderList = new HashSet<Order>();




public Apart(){

}
    public Apart(String apart_name, String apart_city, String apart_address, String apart_phone, String apart_x, String apart_y,
                Integer apart_cost,String apart_description) {
        this.apart_name = apart_name;
        this.apart_city = apart_city;
        this.apart_address = apart_address;
        this.apart_phone = apart_phone;
        this.apart_x = apart_x;
        this.apart_y = apart_y;
        this.apart_cost = apart_cost;
        this.apart_description = apart_description;
    }
    public Apart(Apart apart) {
        this.apart_name = apart.getApart_name();
        this.apart_city = apart.getApart_city();
        this.apart_address = apart.getApart_address();
        this.apart_phone = apart.getApart_phone();
        this.apart_x = apart.getApart_x();
        this.apart_y = apart.getApart_y();
        this.apart_cost = apart.getApart_cost();
        this.apart_description = apart.getApart_description();
    }


    public String getApart_name() {
        return apart_name;
    }

    public void setApart_name(String apart_name) {
        this.apart_name = apart_name;
    }

    public String getApart_city() {
        return apart_city;
    }

    public void setApart_city(String apart_city) {
        this.apart_city = apart_city;
    }

    public String getApart_address() {
        return apart_address;
    }

    public void setApart_address(String apart_address) {
        this.apart_address = apart_address;
    }

    public String getApart_phone() {
        return apart_phone;
    }

    public void setApart_phone(String apart_phone) {
        this.apart_phone = apart_phone;
    }

    public String getApart_x() {
        return apart_x;
    }

    public void setApart_x(String apart_x) {
        this.apart_x = apart_x;
    }

    public String getApart_y() {
        return apart_y;
    }

    public void setApart_y(String apart_y) {
        this.apart_y = apart_y;
    }

    public Integer getApart_cost() {
        return apart_cost;
    }

    public void setApart_cost(Integer apart_cost) {
        this.apart_cost = apart_cost;
    }

    public String getApart_description() {
        return apart_description;
    }

    public void setApart_description(String apart_description) {
        this.apart_description = apart_description;
    }

    public Integer getApartId() {
        return apartId;
    }

    public void setApartId(Integer apartId) {
        this.apartId = apartId;
    }

    public Set<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orderList = orderList;
    }



    public void addOneOrder(Order order){
        orderList.add(order);
    }
}
