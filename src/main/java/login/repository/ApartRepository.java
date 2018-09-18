package login.repository;

import login.entity.Apart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApartRepository extends CrudRepository<Apart, Integer> {
    Apart findByApartId(Integer id);

    @Query(value="select * from apart\n" +
            "where (apart_id not in \n" +
            "(select distinct zak.apart_id from university.zak\n" +
            "where (zak.order_date_begin between ?1 and ?2 )" +
            "or (zak.order_date_end between ?1 and ?2))) and" +
            "(apart.apart_cost < ?3) and (apart.apart_city = ?4)"  ,nativeQuery=true)
    Iterable<Apart> getAparts(Date date_begin,Date date_end,Integer apart_cost, String apart_city );
}
