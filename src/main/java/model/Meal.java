package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal implements Serializable{
    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(mappedBy = "meal",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST},orphanRemoval = true)
    private List<MenuMeal> menumeals = new ArrayList<>();
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 1)
    //    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    private Integer id;
    private String name;
    @Column(name = "price", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private int price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Meal() {

    }

    public Meal(String name, int price) {
        this.name=name;
        this.price = price;
    }

    public Meal(String name) {

       this.name=name;
    }

    public Meal(Integer id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public List<MenuMeal> getMenumeals() {
        return menumeals;
    }

    public void setMenumeals(List<MenuMeal> menumeals) {
        this.menumeals = menumeals;
    }
    public void addMenuMeal(MenuMeal menuMeal){
        addMenuMeal(menuMeal,true);
    }
    void addMenuMeal(MenuMeal menuMeal,boolean set){
        if(menuMeal!=null){
            if(getMenumeals().contains(menuMeal)){
                getMenumeals().set(getMenumeals().indexOf(menuMeal),menuMeal);
            }else{
                getMenumeals().add(menuMeal);
            }
            if(set){
                menuMeal.setMeal(this,false);
            }
        }
    }
    public void removeMenuMeal(MenuMeal menuMeal){
        getMenumeals().remove(menuMeal);
        menuMeal.setMeal(null);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meal = " + name );


        sb.append("price =").append(price);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if ((o == null) || !(o instanceof Meal))
            return false;

        final Meal meal = (Meal)o;

        if (id != null && meal.getId() != null) {
            return id.equals(meal.getId());
        }
        return false;
    }


    @Override
    public int hashCode() {
        final int PRIME = 31;
        return new HashCodeBuilder(getId()%2==0?getId()+1:getId(), PRIME).
                toHashCode();
    }
}
