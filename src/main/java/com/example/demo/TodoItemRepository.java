package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
//効率的にデータベースとのやり取りを行う(手動でCRUD操作を書かないため)
// DB利用の際は必ず必要（JpaRepository）
public interface TodoItemRepository extends JpaRepository<TodoItemEntity, Long> {
   
}
