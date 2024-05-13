package com.mainApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoListDto {
	
	private Long id;
	private String todoTitle;
	private String todoDescription;
	private String taskCompleted;

}
