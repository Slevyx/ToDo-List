package it.objectmethod.dao;

import java.util.List;

import it.objectmethod.models.ToDo;

public interface IToDoDao {

	public ToDo addToDo(Integer id, String description);
	
	public List<ToDo> deleteToDo(Integer id, List<ToDo> toDoList);

	void allowModifies(List<ToDo> toDoList, Integer id);

	public void modifyToDo(List<ToDo> toDoList, Integer id, String modifiedDescription);

	public void setDoneUndone(List<ToDo> toDoList, Integer id);
}
