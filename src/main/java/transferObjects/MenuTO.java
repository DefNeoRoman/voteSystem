package transferObjects;

import java.util.ArrayList;
import java.util.List;

public class MenuTO {
    private Long menuId;
    private String menuName;
    private String cookName;
    private Long placeId;
    private String placeName;
    private List<MealTO> mealTOS;
    private List<String> placeNames;//Доступные Рестораны
    private List<Long> placeIds; //доступные id всех ресторанов

    public MenuTO() {
        this.placeNames = new ArrayList<>();
        this.placeIds = new ArrayList<>();
    }

    public MenuTO(Long menuId,
                  String menuName,
                  String cookName,
                   Long placeId,
                  List<MealTO> mealTOS) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.cookName = cookName;
        this.placeId = placeId;
        this.mealTOS = mealTOS;
    }

    public MenuTO(Long menuId, String menuName, String cookName) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.cookName = cookName;
    }

    public MenuTO(Long menuId,
                  String menuName,
                  String cookName,
                  Long placeId,
                  String placeName) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.cookName = cookName;
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeNames = new ArrayList<>();
        this.placeIds = new ArrayList<>();
    }

    public void setMealTOS(List<MealTO> mealTOS) {
        this.mealTOS = mealTOS;
    }

    public List<MealTO> getMealTOS() {
        return mealTOS;
    }

    public void addPlaceName(String placeName) {
        placeNames.add(placeName);
    }

    public void addPlaceId(Long placeId) {
        placeIds.add(placeId);
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public List<String> getPlaceNames() {
        return placeNames;
    }

    public void setPlaceNames(List<String> placeNames) {
        this.placeNames = placeNames;
    }

    public List<Long> getPlaceIds() {
        return placeIds;
    }

    public void setPlaceIds(List<Long> placeIds) {
        this.placeIds = placeIds;
    }
}
