package model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menus")
public class Menu  extends BaseEntity implements Serializable {

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "menus")
    private Set<Meal> meals = new HashSet<>();
    @Column(name = "cookname", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String cookName;

    public Menu() {
    }

    public Menu(String cookName) {
        this.cookName = cookName;
    }

    public Menu(String name, String cookName) {
        super(name);
        this.cookName = cookName;
    }

    public Menu(Integer id, String name, String cookName) {
        super(id, name);
        this.cookName = cookName;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu{");
        meals.forEach(meal -> sb.append(meal.toString()));
        sb.append("cookName = ").append(cookName);
        return sb.toString();
    }
}
