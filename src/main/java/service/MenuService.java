package service;

import model.Menu;

import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.MenuRepository;
import repository.datajpa.PlaceRepository;
import transferObjects.MenuTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService{



    @Autowired
    private MenuRepository menuRepository;


    public List<Menu> getAll() {
      return menuRepository.findAll();
    }
    public List<MenuTO> getAllMenuTOs(){
        List<MenuTO> menuTOS = new ArrayList<>();
        List<Menu> menuList = menuRepository.findAll();

        menuList.forEach(menu -> {
         menu.getPlaces().forEach(place -> {
             menuTOS.add(new MenuTO(menu.getId(),
                     menu.getName(),
                     menu.getCookName(),
                     place.getId(),
                     place.getName()));
         });
        });
        return menuTOS;
    }

    public void create(Menu object) {
        menuRepository.save(object);
    }


    public Menu get(Long id) {
        return menuRepository.findOne(id);
    }


    public void update(Menu object) {
        menuRepository.save(object);
    }


    public void delete(Long id) {
        menuRepository.delete(id);
    }
}
