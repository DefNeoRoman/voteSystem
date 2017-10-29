package repository.datajpa;

import model.Meal;
import model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
