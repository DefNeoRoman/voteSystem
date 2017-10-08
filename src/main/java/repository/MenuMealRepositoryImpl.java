package repository;

import model.Meal;
import model.MenuMeal;
import org.springframework.stereotype.Repository;
import repository.interfaces.MenuMealRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MenuMealRepositoryImpl implements MenuMealRepository {
    Map<String, MenuMeal> storage = new HashMap<>();
    @Override
    public int size() {
        return storage.size();
    }
    @Override
    public void clear() {
        storage.clear();
    }
    @Override
    public String getSearchKey(String uuid) {
        return uuid;
    }
    @Override
    public  void update(MenuMeal menuMeal, String searchKey) {
        storage.put(searchKey, menuMeal);
    }
    @Override
    public boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }
    @Override
    public void save(MenuMeal menuMeal, String searchKey) {

        storage.put(searchKey, menuMeal);
    }
    @Override
    public MenuMeal get(String searchKey) {
        return storage.get(searchKey);
    }
    @Override
    public void delete(String searchKey) {
        storage.remove(searchKey);
    }
    @Override
    public List<MenuMeal> getAll() {
        return new ArrayList<>(storage.values());
    }
}
