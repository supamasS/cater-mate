package org.supamassirichotiyakul.catermate.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min=2, max=50)
    @Column(name="FIRST_NAME")
    private String firstName;

    @NotNull
    @Size(min=2, max=50)
    private String lastName;

    @NotNull
    @Size(min=2, max=20)
    private String userName;

    @NotNull
    @Size(min=4, max=50)
    private String password;

    @NotNull
    @Size(min=2, max=30)
    private String privilege;

//    @OneToMany(mappedBy = "user", targetEntity = Cart.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    private Set<Cart> carts;

    public User() {
//        carts = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

//    public Set<Cart> getCarts() {
//        return carts;
//    }
//
//    public void setCarts(Set<Cart> carts) {
//        this.carts = carts;
//    }
}
