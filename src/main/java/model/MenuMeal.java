package model;



import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "menumeals")
public class MenuMeal implements Serializable{


    @Id
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @Id
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "meal_id")
    private Meal meal;
    @Transient
    private Integer resForHash;

    public MenuMeal() {
        resForHash = UUID.randomUUID().hashCode();
    }

    public MenuMeal(Menu menu, Meal meal) {
        this.menu = menu;
        this.meal = meal;
        resForHash = getMenu().getId()+getMeal().getId();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {

        setMenu(menu,true);
    }
    void setMenu(Menu menu,boolean add){
        this.menu = menu;
        if(menu != null && add){
            menu.addMenuMeal(this,false);
        }
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {

       setMeal(meal,true);
    }
    void setMeal(Meal meal,boolean add){
        this.meal= meal;
        if(meal != null && add){
            meal.addMenuMeal(this,false);
        }
    }


    public Integer getResForHash() {
        return resForHash;
    }

    public void setResForHash(int resForHash) {
        this.resForHash = resForHash;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if ((o == null) || !(o instanceof MenuMeal))
            return false;

        final MenuMeal menuMeal = (MenuMeal) o;

        if (resForHash != null && menuMeal.getResForHash() != null) {
            return resForHash.equals(menuMeal.getResForHash());
        }
        return false;


    }

    @Override
    public int hashCode() {

        final int PRIME = 31;
        return new HashCodeBuilder(getResForHash()%2==0?getResForHash()+1:getResForHash(), PRIME).
                toHashCode();

    }
}
