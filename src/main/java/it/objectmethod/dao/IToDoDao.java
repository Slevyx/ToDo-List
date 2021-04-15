package it.objectmethod.dao;

import java.util.List;

import it.objectmethod.models.ToDo;

public interface IToDoDao {

	public ToDo addToDo(int id, String description);
	
	public void deleteToDo(int id, List<ToDo> toDoList);

	void allowModifies(List<ToDo> toDoList, int id);

	public void modifyToDo(List<ToDo> toDoList, int id, String modifiedDescription);

	public void setDoneUndone(List<ToDo> toDoList, int id);
}
