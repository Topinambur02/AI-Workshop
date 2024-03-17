package com.aiworkshop.AiWorkShop.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "fullText")
    private String fullText;

    @Column(name = "additionDate")
    @Temporal(TemporalType.DATE)
    private Date additionDate;

    @Column(name = "countOfLikes")
    private int countOfLikes;

    @Column(name = "countOfDislikes")
    private int countOfDislikes;

    @Column(name = "timeToReading")
    private int timeToReading;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User FK_user_id;

}
