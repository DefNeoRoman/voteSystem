package repository;

import model.Meal;
import model.Place;
import org.springframework.stereotype.Repository;
import repository.interfaces.PlaceRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlaceRepositoryImpl implements PlaceRepository {
    Map<String,Place> storage = new HashMap<>();
    @Override
    public void save(Place place, String searchKey) {
        storage.put(searchKey,place);
    }

    @Override
    public Place get(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    public void update(Place place, String searchKey) {
        storage.put(searchKey,place);
    }

    @Override
    public void delete(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    public List<Place> getAll() {
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
