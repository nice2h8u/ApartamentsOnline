package login.repository;


import login.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
     
      Set<Order> findByApartApartId(Integer id);
       Order findByOrderId(Integer id);
}
