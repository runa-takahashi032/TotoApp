package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.TodoItemEntity;
import com.example.demo.TodoItemRepository;


//DBやREACTとやり取りする処理をserverクラスに記述
@Service
public class TodoItemService {
	
	
//データベースの中身を保存するための箱を生成
    private final TodoItemRepository todoItemRepository;
    
    
//serverクラスがデータベースと自由にやり取りできるようにリポジトリを持たせている
    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }
//上記コードはこのクラスでDB操作をできるように準備している

    
    
    
//DBの中身を全て習得（変更をしたりする大前提として中身がないといけない）  
    public List<TodoItemEntity> getAllTodoItems() {
        return todoItemRepository.findAll();
    }
    
    
//ユーザーが追加した値を保存できるようにするための役割
    public TodoItemEntity createTodoItem(TodoItemEntity todoItem) {
        return todoItemRepository.save(todoItem);
    }
    
    
    
//データベースの中身を更新するための処理
    public TodoItemEntity updateTodoItem(Long id, TodoItemEntity todoItem) {
        Optional<TodoItemEntity> existingTodoItem = todoItemRepository.findById(id);
        if (existingTodoItem.isPresent()) {
            todoItem.setId(id);
            return todoItemRepository.save(todoItem);
        } else {
            throw new RuntimeException("Todo item not found with id: " + id);
        }
    }
    
    
//データベースの中身を削除する処理
    public void deleteTodoItem(Long id) {
        todoItemRepository.deleteById(id);
    }
    
    
//指定されたIDに対応するToDoアイテムをデータベースから取得
    public Optional<TodoItemEntity> getTodoItemById(Long id) {
        return todoItemRepository.findById(id);
    }
}
