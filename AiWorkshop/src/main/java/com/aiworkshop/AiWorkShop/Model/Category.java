package com.aiworkshop.AiWorkShop.Model;

import com.aiworkshop.AiWorkShop.Themes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Themes themes;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<User> users;

}
