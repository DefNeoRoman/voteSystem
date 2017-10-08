package repository;

import model.Meal;
import model.PlaceMenu;
import org.springframework.stereotype.Repository;
import repository.interfaces.PlaceMenuRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlaceMenuRepositoryImpl implements PlaceMenuRepository {
    Map<String,PlaceMenu> storage = new HashMap<>();
    @Override
    public void save(PlaceMenu placeMenu, String searchKey) {
        storage.put(searchKey,placeMenu);
    }

    @Override
    public PlaceMenu get(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    public void update(PlaceMenu placeMenu, String searchKey) {
        storage.put(searchKey,placeMenu);
    }

    @Override
    public void delete(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    public List<PlaceMenu> getAll() {
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
