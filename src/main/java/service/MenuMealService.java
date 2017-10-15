package service;

import model.MenuMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.interfaces.MenuMealRepository;
import service.interfaces.VoteSystemService;

import java.util.List;

@Service
public class MenuMealService implements VoteSystemService<MenuMeal>{
    @Autowired
    MenuMealRepository repository;

    public void fillRepository(){

    }
    @Override
    public List<MenuMeal> getAll() {
        return repository.getAll();
    }

    @Override
    public void create(String searchKey, MenuMeal object) {
        repository.save(object,searchKey);
    }

    @Override
    public MenuMeal get(String searchKey) {
        return repository.get(searchKey);
    }

    @Override
    public void update(String searchKey, MenuMeal object) {
        repository.update(object,searchKey);
    }

    @Override
    public void delete(String searchKey) {
        repository.delete(searchKey);
    }
}
