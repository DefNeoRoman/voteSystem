package repository.datajpa;

import model.Place;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select a.role from user_roles a where user_id=?1")
    public List<String> findRoleByUserId(Long userId);
}
