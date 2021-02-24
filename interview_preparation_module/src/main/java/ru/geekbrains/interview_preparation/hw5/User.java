package ru.geekbrains.interview_preparation.hw5;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }


}
