package repository;

import model.User;
import org.springframework.stereotype.Repository;
import repository.interfaces.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> users;
    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void save(User user) {

       users.add(user);
    }

    @Override
    public User get(int id) {
        return users.get(id);
    }

    @Override
    public void update(User user) {
        Objects.requireNonNull(user);
        if(users.contains(user)){
            return;
        }else{
            users.add(user);
        }
    }

    @Override
    public boolean delete(int id) {
        if(!users.contains(users.get(id))){
            return false;
        }
        users.remove(id);
        return true;
    }

    @Override
    public List<User> getAll() {
        return users;
    }
    @Override
    public void clear(){
        users.clear();
    }
}
