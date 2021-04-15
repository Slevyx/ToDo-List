package it.objectmethod.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import it.objectmethod.dao.IToDoDao;
import it.objectmethod.models.ToDo;

public class ToDoDaoImpl implements IToDoDao{

	@Override
	public ToDo addToDo(int id, String description) {
		ToDo toDo = new ToDo();
		toDo.setId(id);
		toDo.setDescription(description);
		toDo.setDone(false);
		toDo.setModified(false);
		return toDo;
	}

	@Override
	public void deleteToDo(int id, List<ToDo> toDoList) {
		toDoList.remove(id);
		for(int i = 0; i < toDoList.size(); i++) {
			toDoList.get(i).setId(i);
		}
	}

	@Override
	public void allowModifies(List<ToDo> toDoList, int id) {
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
	public void modifyToDo(List<ToDo> toDoList, int id, String modifiedDescription) {
		ToDo toDo = toDoList.get(id);
		toDo.setModified(false);
		toDo.setDescription(modifiedDescription);
	}

	@Override
	public void setDoneUndone(List<ToDo> toDoList, int id) {
		ToDo toDo = toDoList.get(id);
		if(!toDo.getModified()) {
			toDo.setDone(!toDo.getDone());
		}
	}
}
