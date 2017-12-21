package model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "menus")
public class Menu implements Serializable {

    @Column(name = "cookname", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String cookName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    private Long id;
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "menumeals",
          joinColumns = @JoinColumn(name = "menu_id"),
           inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private Set<Meal> meals = new HashSet<>();

    @ManyToMany(mappedBy = "menus")//на
    private Set<Place> places = new HashSet<>();
    public Menu() {

    }

    public Menu(String cookName) {
        this.cookName = cookName;
    }

    public Menu(String name, String cookName) {
        this.name = name;
        this.cookName = cookName;
    }

    public Menu(Long id, String name, String cookName) {
        this.id = id;
        this.name = name;
        this.cookName = cookName;
    }
    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }
    public void addPlace(Place place){
        places.add(place);
        place.getMenus().add(this);
    }
    public void removePlace(Place place){
        places.remove(place);
        place.getMenus().remove(this);
    }
    public void addMeal(Meal meal){
        meals.add(meal);
        meal.getMenus().add(this);
    }
    public void removeMeal(Meal meal){
        meals.remove(meal);
        meal.getMenus().remove(this);
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



    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu{");

        sb.append("cookName = ").append(cookName);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if ((o == null) || !(o instanceof Menu))
            return false;

        final Menu menu = (Menu)o;

        if (id != null && menu.getId() != null) {
            return id.equals(menu.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
