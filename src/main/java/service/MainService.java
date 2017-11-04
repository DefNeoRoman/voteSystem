package service;

import model.Meal;
import model.Menu;
import model.Place;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transferObjects.MainTO;
import transferObjects.MealTO;
import transferObjects.MenuTO;
import transferObjects.PlaceTO;

import java.util.*;

@Service
public class MainService {

    @Autowired
    PlaceService placeService;
    @Autowired
    MenuService menuService;
    @Autowired
    MealService mealService;

    //Логика усложняестя
    public Map<PlaceTO,List<MenuTO>> getAllMainTOs(){
        List<MainTO> mainTOS = new ArrayList<>();
        Map<PlaceTO,List<MenuTO>> resultObject = new HashMap<>();
        List<PlaceTO> placeTOS = placeService.getAllTOs();
        List<MenuTO> menuTOS = menuService.getMenuTOsWithMeals();

        for(PlaceTO pto:placeTOS){
            List<MenuTO> lmto = new ArrayList<>();
            for(MenuTO mto :menuTOS){
                if(mto.getPlaceId() == pto.getId()){
                    lmto.add(mto);

                }
            }
           resultObject.put(pto,lmto);
        }

        return resultObject;
    }
}
