package model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "menumeals")
public class MenuMeal extends BaseEntity{
    public MenuMeal() {
    }

    @Column(name = "meal_id", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private int mealId;
    @Column(name = "menu_id", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private int menuId;
    //Здесь уже нужно работать с базой, без базы никак не получится их связать
    public MenuMeal(Integer id, String name, int mealId, int menuId) {
        super(id, name);
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
