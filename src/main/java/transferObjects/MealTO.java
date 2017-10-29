package transferObjects;

import model.Meal;
import model.Menu;

import java.util.LinkedList;
import java.util.List;

public class MealTO {
    private Integer mealId;
    private String mealName;
    private int price;
    private Integer menuId;
    private String menuName;
    private List<String> menuNames;
    private List<Integer> menuIds;

    public MealTO(Integer mealId,
                  String mealName,
                  int price,
                  Integer menuId,
                  String menuName) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.price = price;
        this.menuId = menuId;
        this.menuName = menuName;
        menuNames = new LinkedList<>();
        menuIds = new LinkedList<>();
    }

    public Integer getMealId() {
        return mealId;
    }
    public void addMenuname(String menuName){
        menuNames.add(menuName);
    }
    public void addMenuId(Integer menuId){
        menuIds.add(menuId);
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMealId(Integer mealId) {
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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
