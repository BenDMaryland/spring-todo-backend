package com.ben.todo;

import com.ben.todo.model.Todo;
import com.ben.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/")
public class TodoResource {
   private final TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List <Todo> todos = todoService.findallTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
       Todo todo= todoService.findTodoById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
    Todo newTodo = todoService.addTodo(todo);
    return new ResponseEntity<>(newTodo, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo,@PathVariable Long id){
        Todo updateTodo = todoService.updateTodo(todo, id);
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id) {
        System.out.println("Delete this ID "+ id );
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
