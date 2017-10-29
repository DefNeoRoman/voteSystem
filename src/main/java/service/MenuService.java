package service;

import model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.MenuRepository;
import service.interfaces.VoteSystemService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MenuService{



    @Autowired
    private MenuRepository menuRepository;


    public List<Menu> getAll() {
        return menuRepository.findAll();
    }


    public void create(Menu object) {
        menuRepository.save(object);
    }


    public Menu get(Integer id) {
        return menuRepository.findOne(id);
    }

    @Transactional
    public void update(Menu object) {
        menuRepository.save(object);
    }


    public void delete(Integer id) {
        menuRepository.delete(id);
    }
}
