package it.objectmethod.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import it.objectmethod.dao.IToDoDao;
import it.objectmethod.models.ToDo;

public class ToDoDaoImpl implements IToDoDao{

	@Override
	public ToDo addToDo(Integer id, String description) {
		ToDo toDo = new ToDo();
		toDo.setId(id);
		toDo.setDescription(description);
		toDo.setDone(false);
		toDo.setModified(false);
		return toDo;
	}

	@Override
	public List<ToDo> deleteToDo(Integer id, List<ToDo> toDoList) {
		List<ToDo> filteredList = toDoList.stream().filter(toDo -> toDo.getId() != id).collect(Collectors.toList());
		for(int i = 0; i < filteredList.size(); i++) {
			filteredList.get(i).setId(i);
		}
		return filteredList;
	}

	@Override
	public void allowModifies(List<ToDo> toDoList, Integer id) {
		for(ToDo toDo : toDoList) {
			if(toDo.getId() == id && !toDo.getDone()) {
				toDo.setModified(true);
			}
			else {
				toDo.setModified(false);
			}
		}
	}

	@Override
	public void modifyToDo(List<ToDo> toDoList, Integer id, String modifiedDescription) {
		ToDo toDo = toDoList.get(id);
		toDo.setModified(false);
		toDo.setDescription(modifiedDescription);
	}

	@Override
	public void setDoneUndone(List<ToDo> toDoList, Integer id) {
		ToDo toDo = toDoList.get(id);
		if(!toDo.getModified()) {
			toDo.setDone(!toDo.getDone());
		}
	}
}
