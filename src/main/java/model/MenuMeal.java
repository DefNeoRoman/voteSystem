package model;

public class MenuMeal extends BaseEntity{

    private int mealId;
    private int menuId;
    //Здесь уже нужно работать с базой, без базы никак не получится их связать
    public MenuMeal(Integer uuid, String name, int mealId, int menuId) {
        super(uuid, name);
        this.mealId = mealId;
        this.menuId = menuId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

}
