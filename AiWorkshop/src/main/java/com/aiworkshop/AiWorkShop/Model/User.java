package com.aiworkshop.AiWorkShop.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aiworkshop.AiWorkShop.Exceptions.IncorrectEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "login"),
    @UniqueConstraint(columnNames = "email")
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "email")
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotBlank
    @Column(name = "login")
    private String login;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Post> posts = new ArrayList<>();

    public void setEmail(String email) throws IncorrectEmail {
        if (checkEmail(email)) {
            this.email = email;
        }

        else {
            throw new IncorrectEmail(email);
        }
    }

    public static boolean checkEmail(String email) {

        int indexDot = email.indexOf("@");
        String domain = email.substring(indexDot + 1, email.length());
        String[] domainServices = new String[] {"yandex.ru", "gmail.com", "mail.ru"};
        
        for (int i = 0; i < domainServices.length; i++) {
            if (domain.equals(domainServices[i])) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "User id -> " + id + "\n" + "User login -> " + login + "\n" + "User password -> " + password + "\n";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
      return password;
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
}
