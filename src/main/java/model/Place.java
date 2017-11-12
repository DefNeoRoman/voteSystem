package model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.DataOutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "places")
public class Place  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    private Long id;
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;
    @Column(name = "vote", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private int votes;
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "placemenus",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private Set<Menu> menus = new HashSet<>();

    public Place() {
        this.votes = 0;
    }

    public Place(String name) {
        this.name = name;
        this.votes = 0;
    }
    public void addMenu(Menu menu){
        menus.add(menu);
        menu.getPlaces().add(this);
    }
    public void removeMenu(Menu menu){
        menus.remove(menu);
        menu.getPlaces().remove(this);
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

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
    public void incVote(){
        this.votes++;
    }
    public void decVote(){
        this.votes--;
    }

}
