package com.mainApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mainApplication.entity.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}
