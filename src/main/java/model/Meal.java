package model;

public class Meal extends BaseEntity {
    private int price;
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
