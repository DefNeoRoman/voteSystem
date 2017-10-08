package repository;

import model.Meal;
import model.Menu;
import org.springframework.stereotype.Repository;
import repository.interfaces.MenuRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    Map<String,Menu> storage = new HashMap<>();
    @Override
    public void save(Menu menu, String searchKey) {
        storage.put(searchKey, menu);
    }

    @Override
    public Menu get(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    public void update(Menu menu, String searchKey) {
        storage.put(searchKey,menu);
    }

    @Override
    public void delete(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    public List<Menu> getAll() {
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
