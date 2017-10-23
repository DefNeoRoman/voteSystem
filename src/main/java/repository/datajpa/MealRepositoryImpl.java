package repository.datajpa;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import repository.interfaces.MealRepository;

import java.util.List;

@Repository
public class MealRepositoryImpl implements MealRepository{

    @Autowired
    private CrudMealRepository crudMealRepository;
    @Override
    public void save(Meal meal) {

    }

    @Override
    public Meal get(int id) {
        return null;
    }

    @Override
    public void update(Meal meal, String searchKey) {

    }

    @Override
    public void delete(String searchKey) {

    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String getSearchKey(String uuid) {
        return null;
    }

    @Override
    public boolean isExist(String searchKey) {
        return false;
    }
}
