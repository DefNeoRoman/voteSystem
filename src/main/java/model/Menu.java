package model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name = "menus")
public class Menu  extends BaseEntity {
    @Column(name = "cookname", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String cookName;

    public Menu() {
    }

    public Menu(String cookName) {
        this.cookName = cookName;
    }



    public Menu(Integer id, String name, String cookName) {
        super(id, name);
        this.cookName = cookName;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }
}
