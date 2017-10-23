package model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity {
    @Column(name = "price", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private int price;

    public Meal() {
    }

    public Meal(String uuid, String name, int price) {
        super(uuid, name);
        this.price = price;
    }
    public Meal(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

  }
