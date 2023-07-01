package com.funnycode.todoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepositoryJPA todoRepositoryJPA;
    public List<Todo> getAll() {
        List<Todo> todoListByTitleOrDetail = todoRepositoryJPA.findAllByTitleOrDetail("monday","code");
        return todoRepositoryJPA.findAll();
    }

    public void save(Todo todo) {
        todoRepositoryJPA.save(todo);
    }

    public void deleteById(int id) {
        todoRepositoryJPA.deleteById(id);
    }

    public Todo findById(int id) {
        return todoRepositoryJPA.findById(id).get();
    }
}
