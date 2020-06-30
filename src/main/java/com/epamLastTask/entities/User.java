package com.epamLastTask.entities;

import com.epamLastTask.entities.enums.Role;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Пожалуйста введите Ваш логин")
    @Length(max = 128, message = "Слишком большое")
    private String username;
    @NotBlank(message = "Пожалуйста введите Ваш логин")
    @Email(message = "Некоректный email")
    private String email;
    @NotBlank(message = "Пожалуйста введите Ваш пароль")
    @Length(max = 128, message = "Пароль слишком длинный")
    private String password;
    @NotBlank(message = "Пожалуйста введите Ваш номер пасспорта")
    private String passportNumb;
    

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;
    @ManyToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Order> order;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order.add(order);
    }

    public Long getId() {
        return id;
    }

    public String getPassportNumb() {
        return passportNumb;
    }

    public void setPassportNumb(String passportNumb) {
        this.passportNumb = passportNumb;
    }
}
