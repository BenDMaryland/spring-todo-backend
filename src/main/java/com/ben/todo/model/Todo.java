package com.ben.todo.model;

// helps to convert to string for easier usage in DB
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;

    public Todo() {}

    public Todo(String task ){
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}
