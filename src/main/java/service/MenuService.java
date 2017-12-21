package service;

import model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuRepository;
import transferObjects.MealTO;
import transferObjects.MenuTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {


    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MealService mealService;

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public List<MenuTO> getAllMenuTOs() {
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

    public List<MenuTO> getMenuTOsWithMeals() {
        List<Menu> menuList = menuRepository.findAll();
        List<MealTO> mealList = mealService.getAll();

        List<MenuTO> menuTOS = new ArrayList<>();
        menuList.forEach(menu -> {
            menu.getPlaces().forEach(place -> {
                List<MealTO> interList = new ArrayList<>();
                mealList.forEach(mealTO -> {
                    if (mealTO.getMenuId().equals(menu.getId())) {
                        interList.add(mealTO);
                    }
                });
                menuTOS.add(new MenuTO(menu.getId(),
                        menu.getName(),
                        menu.getCookName(),
                        place.getId(),
                        interList));
            });

        });

        return menuTOS;
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
