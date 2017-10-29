package model;



import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "menumeals")
public class MenuMeal implements Serializable{

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 1)
    //    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    private Long id;
    @Id
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @Id
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
    @Transient
    private int resForHash;

    public MenuMeal() {
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


    public int getResForHash() {
        return resForHash;
    }

    public void setResForHash(int resForHash) {
        this.resForHash = resForHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if ((o == null) || !(o instanceof MenuMeal))
            return false;

        final MenuMeal menuMeal = (MenuMeal) o;

        if (id != null && menuMeal.getId() != null) {
            return id.equals(menuMeal.getId());
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
