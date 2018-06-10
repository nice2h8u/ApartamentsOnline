package login.repository;

import login.entity.Apart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartRepository extends CrudRepository<Apart, Integer> {
    Apart findByApartId(Integer id);
}
