package login.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import login.entity.*;
import login.repository.ApartRepository;
import login.repository.OrderRepository;
import login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Set;
import java.util.Date;

@Service
public class ApartController implements IApartController {

    @Autowired
    private ApartRepository apartRepository;
    @Autowired
    private OrderRepository orderRepository;



public Iterable<Apart> listAllAparts() {
    return apartRepository.getAllApparts();
}

    public Iterable<Apart> listAvaliableAparts(java.sql.Date date_begin, java.sql.Date date_end,Integer apart_cost, String apart_city) {

        return apartRepository.getAparts(date_begin,date_end,apart_cost,apart_city);
    }

    public void deleteApart(Integer id) {

        //orderRepository.delete(orderRepository.find); не надо удалять заказ, если нет отеля
        apartRepository.delete(id);
    }


  /*  public Apart add(String apart_name, String apart_city, String apart_address, String apart_phone, String apart_x, String apart_y,
                     Integer apart_cost,String apart_description, String apart_image_url) {

        return apartRepository.save(new Apart(apart_name,apart_city,apart_address, apart_phone, apart_x, apart_y,
                apart_cost, apart_description,apart_image_url));
    }*/

    public Apart add(Apart apart) {

        return apartRepository.save(new Apart(apart.getApart_name(),apart.getApart_city(),apart.getApart_address(), apart.getApart_phone(), apart.getApart_x(),
                apart.getApart_y(), apart.getApart_cost(), apart.getApart_description(), apart.getApart_image_url()));
    }




    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }


    public Set<Order> findOrdersByApartId(Integer id) {

        return  apartRepository.findByApartId(id).getOrderList();
    }

    //    @Override
    public Set<Order> addOrder(String order_name,Date order_date_begin,Date order_date_end, Long order_cost, Integer id) { //TODO: make back for adding/deleting numer


        apartRepository.findByApartId(id).addOneOrder(orderRepository.save(new Order(order_name,order_date_begin,order_date_end,order_cost)));
        return apartRepository.findByApartId(id).getOrderList();
    }


    public void deleteOrder(Integer orderId) {

        orderRepository.delete(orderId);
    }




}
