package transferObjects;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class UserTO  {
    private static final long serialVersionUID = 1L;
    protected Long id;

    @NotBlank

    private String name;

    @Email
    @NotBlank
    @Size(max = 100)

    private String email;

    @Size(min = 5, max = 32, message = "length must between 5 and 32 characters")
    private String password;




    public  UserTO() {
    }

    public  UserTO(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                "," + '\'' +
                '}';
    }
}
