package repository;

import model.Meal;
import org.springframework.stereotype.Repository;
import repository.interfaces.MealRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MealRepositoryImpl implements MealRepository {
    Map<String,Meal> storage = new HashMap<>();
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
    public  void update(Meal meal, String searchKey) {
        storage.put(searchKey, meal);
    }
    @Override
    public boolean isExist(String searchKey) {
    return storage.containsKey(searchKey);
    }
    @Override
    public void save(Meal meal, String searchKey) {
        storage.put(searchKey, meal);
    }
    @Override
    public Meal get(String searchKey) {
    return storage.get(searchKey);
    }
    @Override
    public void delete(String searchKey) {
        storage.remove(searchKey);
    }
    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(storage.values());
    }
}
