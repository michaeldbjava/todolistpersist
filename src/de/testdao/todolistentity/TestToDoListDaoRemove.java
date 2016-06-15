package de.testdao.todolistentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.dao.ToDoListDao;

public class TestToDoListDaoRemove {

	public TestToDoListDaoRemove() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		ToDoListDao todolistDao = new ToDoListDao(em);
		em.close();

	}

}
