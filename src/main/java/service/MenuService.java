package service;

import model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.interfaces.MenuRepository;
import service.interfaces.VoteSystemService;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService implements VoteSystemService<Menu>{
    private final Menu menu1 = new Menu(900006,"завтрак","Вова");
    private final Menu menu2 = new Menu(900007,"обед","Петя");
    private final Menu menu3 = new Menu(900008,"ужин","Вася");
    private final Menu menu4 = new Menu(900009,"ланч","Дима");
    private final Menu menu5 = new Menu(9000010,"фастфуд","Егор");


    @Autowired
    private MenuRepository menuRepository;
    public void fillRepository(){
        menuRepository.save(menu1,menu1.getUuid());
        menuRepository.save(menu2,menu2.getUuid());
        menuRepository.save(menu3,menu3.getUuid());
        menuRepository.save(menu4,menu4.getUuid());
        menuRepository.save(menu5,menu5.getUuid());

    }
    @Override
    public List<Menu> getAll() {
        return menuRepository.getAll();
    }

    @Override
    public void create(String searchKey, Menu object) {
        menuRepository.save(object,searchKey);
    }

    @Override
    public Menu get(String searchKey) {
        return menuRepository.get(searchKey);
    }

    @Override
    public void update(String searchKey, Menu object) {
        menuRepository.update(object,searchKey);
    }

    @Override
    public void delete(String searchKey) {
        menuRepository.delete(searchKey);
    }
}
