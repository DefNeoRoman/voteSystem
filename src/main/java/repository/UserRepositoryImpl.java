package repository;

import model.Meal;
import model.User;
import org.springframework.stereotype.Repository;
import repository.interfaces.UserRepository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    Map<String,User> storage = new HashMap<>();
    @Override
    public void save(User user, String searchKey) {
        storage.put(searchKey,user);
    }

    @Override
    public User get(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    public void update(User user, String searchKey) {
        storage.put(searchKey,user);
    }

    @Override
    public void delete(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }
}
