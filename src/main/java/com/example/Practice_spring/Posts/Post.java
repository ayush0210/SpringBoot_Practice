package com.example.Practice_spring.Posts;

import com.example.Practice_spring.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Post")
public class Post {

    @Id
    @NotNull(message = "Need id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


   @NotBlank(message = "Title cannot be blank")
    private String title;

    @Column(length = 4000)
    private String body;


    public Post() {

    }

    public Post(Long id, User user, String title, String body) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
