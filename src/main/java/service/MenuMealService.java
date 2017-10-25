package service;

import model.MenuMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.MenuMealRepository;
import service.interfaces.VoteSystemService;

import java.util.List;

@Service
public class MenuMealService{
    @Autowired
    MenuMealRepository repository;
    public List<MenuMeal> getAll() {
        return repository.findAll();
    }

    public void create(MenuMeal object) {
        repository.save(object);
    }

    public MenuMeal get(Integer searchKey) {
        return repository.findOne(searchKey);
    }

    public void update(MenuMeal object) {
        repository.save(object);
    }

    public void delete(Integer searchKey) {
        repository.delete(searchKey);
    }
}
