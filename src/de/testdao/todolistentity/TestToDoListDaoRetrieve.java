package de.testdao.todolistentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.dao.ToDoListDao;
import de.entity.todolist.Todolist;

public class TestToDoListDaoRetrieve {

	public TestToDoListDaoRetrieve() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		
		ToDoListDao todolistDao = new ToDoListDao(em);
		Todolist todolist = todolistDao.retrieveTodolist(1);
		System.out.println(todolist.getTodolist());
		em.close();
	}

}
