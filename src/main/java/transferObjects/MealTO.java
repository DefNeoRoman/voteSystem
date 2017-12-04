package transferObjects;

import java.util.LinkedList;
import java.util.List;

public class MealTO {
    private Long mealId;
    private String mealName;
    private int price;
    private Long menuId;
    private String menuName;
    private List<String> menuNames;
    private List<Long> menuIds;

    public MealTO(Long mealId,
                  String mealName,
                  int price,
                  Long menuId,
                  String menuName) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.price = price;
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuNames = new LinkedList<>();
        this.menuIds = new LinkedList<>();
    }

    public MealTO() {
       this.menuNames = new LinkedList<>();
       this.menuIds = new LinkedList<>();
    }

    public Long getMealId() {
        return mealId;
    }
    public void addMenuname(String menuName){
        menuNames.add(menuName);
    }
    public void addMenuId(Long menuId){
        menuIds.add(menuId);
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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


}
