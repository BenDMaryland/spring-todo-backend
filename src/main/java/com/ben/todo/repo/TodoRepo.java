package com.ben.todo.repo;

import com.ben.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepo extends JpaRepository<Todo, Long> {

    void deleteTodoById(Long id);
    Optional<Todo> findTodoById(Long id);


}
