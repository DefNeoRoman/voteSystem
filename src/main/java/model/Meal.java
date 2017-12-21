package model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "price", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private int price;
    @ManyToMany(mappedBy = "meals")//на
    private Set<Menu> menus = new HashSet<>();
    public Meal() {

    }

    public Meal(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Meal(String name) {

        this.name = name;
    }

    public Meal(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public void addMenu(Menu menu) {
        menus.add(menu);
        menu.getMeals().add(this);

    }

    public void removeMenu(Menu menu) {
        menus.remove(menu);
        menu.getMeals().remove(this);
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meal = " + name);


        sb.append("price =").append(price);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if ((o == null) || !(o instanceof Meal))
            return false;

        final Meal meal = (Meal) o;

        if (id != null && meal.getId() != null) {
            return id.equals(meal.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
