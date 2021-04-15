package it.objectmethod.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.dao.IToDoDao;
import it.objectmethod.dao.impl.ToDoDaoImpl;
import it.objectmethod.models.ToDo;

@WebServlet("/ModifyToDo")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modifiedDescription = request.getParameter("modify");
		IToDoDao toDoDao = new ToDoDaoImpl();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		List<ToDo> toDoList = (List<ToDo>) session.getAttribute("toDoList");
		if(modifiedDescription == null || modifiedDescription.isBlank()) {
			request.setAttribute("error", "ToDo modified description cannot be empty.");
		}
		else {
			toDoDao.modifyToDo(toDoList, Integer.parseInt(id), modifiedDescription);
		}
		request.setAttribute("toDoList", toDoList);
		request.getRequestDispatcher("pages/ToDoList.jsp").forward(request, response);
	}
}
