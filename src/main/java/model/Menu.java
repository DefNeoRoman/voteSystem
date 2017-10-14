package model;

public class Menu  extends BaseEntity {
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

    public Menu(String uuid, String name, String cookName) {
        super(uuid, name);
        this.cookName = cookName;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }
}
