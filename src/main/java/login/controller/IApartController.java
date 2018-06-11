package login.controller;


import login.entity.Apart;
import login.entity.Order;


import java.util.Date;
import java.util.Set;

public interface IApartController {

    Iterable<Apart> listAllAparts();
    void deleteApart(Integer id);
    Apart add(String apart_name, String apart_city, String apart_address, String apart_phone, String apart_x, String apart_y,
                Integer apart_cost,String apart_description);
    Apart add(Apart apart);
    Iterable<Order> listAllOrders();
    Set<Order> findOrdersByApartId(Integer id);
   Set<Order> addOrder(String order_name, Date order_date_begin, Date order_date_end, Long order_cost, Integer id);
    void deleteOrder(Integer id);


}
