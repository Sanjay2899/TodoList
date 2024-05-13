package com.mainApplication.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainApplication.dto.TodoListDto;
import com.mainApplication.serviceImplementation.TodoListServiceImplementation;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/todoList")
public class TodoListRestController {
	
	@Autowired
	TodoListServiceImplementation todoListServiceImplementation;
	
	@PostMapping
	public ResponseEntity<TodoListDto> createTodoList(@RequestBody TodoListDto todoListDto)
	{
		TodoListDto todoListDtoSaved=todoListServiceImplementation.createTodoList(todoListDto);
		return new ResponseEntity<>(todoListDtoSaved,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TodoListDto> getTodoListId(@PathVariable("id") Long todoListId)
	{
		TodoListDto todoListDto =todoListServiceImplementation.getToDoListById(todoListId);
		return ResponseEntity.ok(todoListDto);
	}
	
	@GetMapping
	public ResponseEntity<List<TodoListDto>> getAllTodoList()
	{
		List<TodoListDto> todoListDtos=todoListServiceImplementation.getAllTodoList();
		return ResponseEntity.ok(todoListDtos);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTodoListById(@PathVariable("id") Long todoListId)
	{
		todoListServiceImplementation.deleteTodoList(todoListId);
		return ResponseEntity.ok("task deleted successfully ");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TodoListDto> updateTodoList(@PathVariable("id") Long todoListId,@RequestBody TodoListDto todoListDto)
	{
		TodoListDto todoListDtoUpdate=todoListServiceImplementation.updateTodoList(todoListId,todoListDto);
		return ResponseEntity.ok(todoListDtoUpdate);
	}
	@PutMapping("/status/{id}")
	public ResponseEntity<TodoListDto> updateTodoListStatus(@PathVariable("id") Long todoListId,@RequestBody TodoListDto todoListDto)
	{
		TodoListDto todoListDtoUpdate=todoListServiceImplementation.updateTodoListStatus(todoListId,todoListDto);
		return ResponseEntity.ok(todoListDtoUpdate);
	}

}
