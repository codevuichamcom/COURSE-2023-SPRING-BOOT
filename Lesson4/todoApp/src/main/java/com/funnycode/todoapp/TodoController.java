package com.funnycode.todoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    //Hiển thị danh sách Todo
    @GetMapping("/todos")
    public String getAllTodo(Model model) {
        List<Todo> todoList = todoService.getAll();
        model.addAttribute("todoList", todoList);
        return "todo";
    }

    //Xử lý việc thêm todo
    @GetMapping("/add-todo")
    public String addTodo(Model model) {
        model.addAttribute("todo", Todo.builder().build());
        return "addTodo";
    }


    //Xử lý việc thêm todo
    @PostMapping("/add-todo")
    public String saveTodo(@ModelAttribute Todo todo) {
        todoService.save(todo);
        return "redirect:/todos";
    }

    //Xử lý xóa todo
    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:/todos";
    }

    @GetMapping("/update-todo")
    public String updateTodo(Model model, @RequestParam int id) {
        //Tìm todo có id = id truyền vào
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "addTodo";
    }
}
