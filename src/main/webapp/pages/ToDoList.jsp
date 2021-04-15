<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>To Do List</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
	</head>
	<body>
		<div class="header">
			<form autocomplete="off" action="/ToDoList/AddToDo">
				<input type="text" name="toDo"/>
				<input type="submit" value="Add ToDo"/>
			</form>
		</div>
		<p>${error}</p>
		<c:choose>
			<c:when test="${empty toDoList}">
				<p>Your To Do List is empty.</p>
			</c:when>
			<c:otherwise>
				<div class="toDoList">
					<c:forEach items="${toDoList}" var="toDo">
						<div class="toDo">
							<div>${toDo.id + 1}</div>
							<div>
								<c:choose>
								<c:when test="${toDo.modified}">
									<form autocomplete="off" action="/ToDoList/ModifyToDo">
										<input type="text" name="modify" value="${toDo.description}">
										<input type="submit" value="Submit Changes">
									</form>
								</c:when>
								<c:otherwise>
									<div class="description-field"><div class="${toDo.done ? 'done' : ''}">${toDo.description}</div><a href="/ToDoList/AllowModifies?id=${toDo.id}"><img src="${pageContext.request.contextPath}/img/modify.png" alt="Modify" width="40"></a></div>
								</c:otherwise>
								</c:choose>
							</div>
							<a href="/ToDoList/DoneUndone?id=${toDo.id}" class="btn btn-primary">${toDo.done ? 'Undone' : 'Done'}</a>
							<div><a href="/ToDoList/DeleteToDo?id=${toDo.id}"><img src="${pageContext.request.contextPath}/img/recycleBin.png" alt="Delete" width="50"></a></div>
						</div>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
	</body>
</html>