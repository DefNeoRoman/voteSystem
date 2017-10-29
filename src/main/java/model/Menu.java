package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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
public class Menu implements Serializable {
    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "menu")
    private List<MenuMeal> menuMeals = new ArrayList<>();
    @Column(name = "cookname", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String cookName;
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 1)
    //    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    private Integer id;
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;


    public Integer getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Menu() {
    }

    public Menu(String cookName) {
        this.cookName = cookName;
    }

    public Menu(String name, String cookName) {
        this.name = name;
        this.cookName = cookName;
    }

    public Menu(Integer id, String name, String cookName) {
       this.id = id;
       this.name = name;
        this.cookName = cookName;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public List<MenuMeal> getMenuMeals() {
        return menuMeals;
    }

    public void setMenuMeals(List<MenuMeal> menuMeals) {
        this.menuMeals = menuMeals;
    }
    public void addMenuMeal(MenuMeal menuMeal){
      addMenuMeal(menuMeal,true);
    }
    void addMenuMeal(MenuMeal menuMeal,boolean set){
        if(menuMeal!=null){
            if(getMenuMeals().contains(menuMeal)){
                getMenuMeals().set(getMenuMeals().indexOf(menuMeal),menuMeal);
            }else{
                getMenuMeals().add(menuMeal);
            }
            if(set){
                menuMeal.setMenu(this,false);
            }
        }
    }
    public void removeMenuMeal(MenuMeal menuMeal){

        getMenuMeals().remove(menuMeal);
        menuMeal.setMenu(null);
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
        final int PRIME = 31;
        return new HashCodeBuilder(getId()%2==0?getId()+1:getId(), PRIME).
                toHashCode();
    }
}
