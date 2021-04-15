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

@WebServlet("/DeleteToDo")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		IToDoDao toDoDao = new ToDoDaoImpl();
		HttpSession session = request.getSession();
		List<ToDo> toDoList = (List<ToDo>) session.getAttribute("toDoList");
		if(id == null) {
			request.setAttribute("error", "Cannot Delete Null ToDo.");
		}
		else {
			toDoDao.deleteToDo(Integer.parseInt(id), toDoList);
		}
		session.setAttribute("toDoList", toDoList);
		request.getRequestDispatcher("pages/ToDoList.jsp").forward(request, response);
	}
}
