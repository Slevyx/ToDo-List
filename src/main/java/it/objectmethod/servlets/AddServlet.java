package it.objectmethod.servlets;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/AddToDo")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toDoDescription = request.getParameter("toDo");
		ToDo toDo = null;
		int id;
		IToDoDao toDoDao = new ToDoDaoImpl();
		HttpSession session = request.getSession();
		List<ToDo> toDoList = (List<ToDo>) session.getAttribute("toDoList") != null ? (List<ToDo>) session.getAttribute("toDoList") : new ArrayList<>();
		if(toDoDescription == null || toDoDescription.isBlank()) {
			request.setAttribute("error", "ToDo description cannot be empty.");
		}
		else {
			id = toDoList.size();
			toDo = toDoDao.addToDo(id, toDoDescription);
			toDoList.add(toDo);
		}
		session.setAttribute("toDoList", toDoList);
		request.getRequestDispatcher("pages/ToDoList.jsp").forward(request, response);
	}
}
