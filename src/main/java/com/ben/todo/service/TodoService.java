package com.ben.todo.service;

import com.ben.todo.exception.TodoNotFoundException;
import com.ben.todo.model.Todo;
import com.ben.todo.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepo todoRepo;

    @Autowired
    public TodoService(TodoRepo todoRepo){
        this.todoRepo =todoRepo;
    }

    public Todo addTodo(Todo todo){
        return todoRepo.save(todo);
    }

    public List<Todo> findallTodos(){
        return todoRepo.findAll();
    }

    public Todo updateTodo(Todo todo, Long id){
        Todo existingTodo = todoRepo.findTodoById(id).orElse(null);
        System.out.println(existingTodo);
       existingTodo.setTask(todo.getTask());
        return todoRepo.save(existingTodo);
    }

    public void deleteTodo(Long id){
        todoRepo.deleteTodoById(id);
    }

    public Todo findTodoById(Long id){
      return   todoRepo.findTodoById(id)
              .orElseThrow(() -> new TodoNotFoundException("Todo by id " + id + " was not found"));
    }
}
