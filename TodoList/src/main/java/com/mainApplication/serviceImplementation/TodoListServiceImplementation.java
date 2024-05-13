package com.mainApplication.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mainApplication.dto.TodoListDto;
import com.mainApplication.entity.TodoList;
import com.mainApplication.mapper.TodoListMapper;
import com.mainApplication.repository.TodoListRepository;

@Service
public class TodoListServiceImplementation {
	
	@Autowired
	TodoListRepository todoListRepository;
	
	public TodoListDto createTodoList(TodoListDto todoListDto)
	{
		TodoList todoList=TodoListMapper.mapToTodoList(todoListDto);
		TodoList savedTodoList=todoListRepository.save(todoList);
		return TodoListMapper.mapToTodoListDto(savedTodoList);
	}
	
	public TodoListDto getToDoListById(Long todoListId)
	{
		Optional<TodoList> opt=todoListRepository.findById(todoListId);
		if(opt.get()!=null)
		{
			TodoList todoList=opt.get();
			return TodoListMapper.mapToTodoListDto(todoList);
		}
		return null;
	}
	
	public List<TodoListDto> getAllTodoList(){
		List<TodoList> todoLists=todoListRepository.findAll();
		if(todoLists!=null)
		{
			
		return todoLists.stream().map((todoList)->
			TodoListMapper.mapToTodoListDto(todoList)
				).collect(Collectors.toList());
		}
		return null;
		
	}
	
	public TodoListDto updateTodoList(Long todoListId,TodoListDto upadateTodoList)
	{
		Optional<TodoList> opt=todoListRepository.findById(todoListId);
		TodoList todoList=null;
		if(opt.get()!=null)
		{
			todoList=opt.get();
			todoList.setTodoTitle(upadateTodoList.getTodoTitle());
			todoList.setTodoDescription(upadateTodoList.getTodoDescription());
			todoList.setTaskCompleted(upadateTodoList.getTaskCompleted());
			TodoList savedTodoList=todoListRepository.save(todoList);
			return TodoListMapper.mapToTodoListDto(savedTodoList);
		}
		return null;
	}
	public TodoListDto updateTodoListStatus(Long todoListId,TodoListDto upadateTodoList)
	{
		Optional<TodoList> opt=todoListRepository.findById(todoListId);
		TodoList todoList=null;
		if(opt.get()!=null)
		{
			todoList=opt.get();
			todoList.setTaskCompleted(upadateTodoList.getTaskCompleted());
			TodoList savedTodoList=todoListRepository.save(todoList);
			return TodoListMapper.mapToTodoListDto(savedTodoList);
		}
		return null;
	}
	
	public  void deleteTodoList(Long todoListId)
	{
		todoListRepository.deleteById(todoListId);
		
	}

}
	


