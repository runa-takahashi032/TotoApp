package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TodoItemService;

//RESTfulなWebサービスのエンドポイントクラス

@RestController
//サイトのURL
@RequestMapping("/api/todo")
public class TodoItemController {
//TodoItemserverクラスの中身を使用できるように処理
    @Autowired
    private TodoItemService todoItemService;
//ToDoアイテムのリストを取得するためのエンドポイント
    @GetMapping
    public List<TodoItemEntity> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }
//新しいToDoアイテムをデータベースに保存する処理
    @PostMapping
    public TodoItemEntity createTodoItem(@RequestBody TodoItemEntity todoItem) {
        return todoItemService.createTodoItem(todoItem);
    }
//ToDoアイテムを削除するためのエンドポイント
    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable Long id) {
        todoItemService.deleteTodoItem(id);
    }
}
