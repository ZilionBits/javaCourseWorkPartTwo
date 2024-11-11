package lt.techin.springTaskOne.rest.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class UserPrank {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;

    public UserPrank() {

    }

    public UserPrank(String userName, String firstName, String lastName, String email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrank userPrank = (UserPrank) o;
        return Objects.equals(id, userPrank.id) && Objects.equals(userName, userPrank.userName) && Objects.equals(firstName, userPrank.firstName) && Objects.equals(lastName, userPrank.lastName) && Objects.equals(email, userPrank.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, firstName, lastName, email);
    }
}
