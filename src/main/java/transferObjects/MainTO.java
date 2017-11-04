package transferObjects;

import model.Meal;
import model.Menu;
import model.Place;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class MainTO implements Serializable {

    private PlaceTO placeTO;
    private List<MenuTO> menuTOS;
    private List<MealTO> mealTOS;

    public MainTO(PlaceTO placeTO, List<MenuTO> menuTOS, List<MealTO> mealTOS) {
        this.placeTO = placeTO;
        this.menuTOS = menuTOS;
        this.mealTOS = mealTOS;
    }

    public MainTO(PlaceTO placeTO, List<MenuTO> menuTOS) {
        this.placeTO = placeTO;
        this.menuTOS = menuTOS;

    }

    public PlaceTO getPlaceTO() {
        return placeTO;
    }

    public void setPlaceTO(PlaceTO placeTO) {
        this.placeTO = placeTO;
    }

    public List<MenuTO> getMenuTOS() {
        return menuTOS;
    }

    public void setMenuTOS(List<MenuTO> menuTOS) {
        this.menuTOS = menuTOS;
    }

    public List<MealTO> getMealTOS() {
        return mealTOS;
    }

    public void setMealTOS(List<MealTO> mealTOS) {
        this.mealTOS = mealTOS;
    }
}
