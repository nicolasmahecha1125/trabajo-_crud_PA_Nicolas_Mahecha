package com.utadeo.taskapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;

    @NonNull
    @Column(nullable = false)
    private  String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private  User user;
    Task(){}


    public Task(String title,String description, User user){
        this.title = title;
        this.description = description;
        this.user = user;
    }



    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription( String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
