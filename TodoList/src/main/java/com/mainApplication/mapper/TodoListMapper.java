package com.mainApplication.mapper;
import com.mainApplication.dto.TodoListDto;
import com.mainApplication.entity.TodoList;

public class TodoListMapper {
	
	public static TodoListDto mapToTodoListDto(TodoList todoList)
	{
		return new TodoListDto(
				todoList.getId(),
				todoList.getTodoTitle(),
				todoList.getTodoDescription(),
				todoList.getTaskCompleted()
				);
	}
	
	public static TodoList mapToTodoList(TodoListDto todoListDto)
	{
		return new TodoList(
				todoListDto.getId(),
				todoListDto.getTodoTitle(),
				todoListDto.getTodoDescription(),
				todoListDto.getTaskCompleted()
				);
				
	}

}
