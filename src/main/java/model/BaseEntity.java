package model;

public class BaseEntity {
    private int id;
    private String uuid;
    private String name;

    public BaseEntity() {
    }

    public BaseEntity(String name) {
        this.name = name;
    }

    public BaseEntity(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public int getId() {
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
}
