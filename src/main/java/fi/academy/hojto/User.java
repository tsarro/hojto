package fi.academy.hojto;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nickname")
    private String nickname;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.data.annotation.Transient;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "email", nullable = false, unique = true)
//    @Email(message = "Please provide a valid e-mail")
//    @NotEmpty(message = "Please provide an e-mail")
//    private String email;
//
//    @Column(name = "password")
//    @Transient
//    private String password;
//
//    @Column(name = "name")
//    @NotEmpty(message = "Anna nimi")
//    private String name;
//
//
//    @Column(name = "enabled")
//    private boolean enabled;
//
//    @Column(name = "confirmation_token")
//    private String confirmationToken;
//
//    public String getConfirmationToken() {
//        return confirmationToken;
//    }
//
//    public void setConfirmationToken(String confirmationToken) {
//        this.confirmationToken = confirmationToken;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean value) {
//        this.enabled = value;
//    }
//}

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
//public class User {
//    @Id @GeneratedValue
//    private int id;
//    private String name;
//
//    public User() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
