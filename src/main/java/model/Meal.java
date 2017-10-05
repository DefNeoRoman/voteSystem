package model;

public class Meal extends BaseEntity {
    private int price;
    public Meal(int id, String name, int price) {
        super(id, name);
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
  }
