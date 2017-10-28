package model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity implements Serializable{
    //JPA/Hibernate: detached entity passed to persist
    //The solution is simple,
    // just use the CascadeType.MERGE
    // instead of CascadeType.PERSIST or CascaCadeType.ALL.
   // I had the same problem and CascadeType.MERGE has worked for me.
   // I hope you are sorted.
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "menumeals",
            joinColumns = @JoinColumn(name = "meal_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id",
                    referencedColumnName = "id"))
    private Set<Menu> menus;
    @Column(name = "price", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private int price;

    public Meal() {
    }

    public Meal(String name, int price) {
        super(name);
        this.price = price;
    }

    public Meal(String name) {
        super(name);
    }

    public Meal(Integer id, String name, int price) {
        super(id, name);
        this.price = price;
    }


    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenuList(Set<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meal = " + name );
        menus.forEach((h)->{
            sb.append("находится в меню:"+h.getName());
        });

        sb.append("price =").append(price);
        return sb.toString();
    }
}
