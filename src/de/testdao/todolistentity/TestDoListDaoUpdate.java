package de.testdao.todolistentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.dao.ToDoListDao;

public class TestDoListDaoUpdate {

	public TestDoListDaoUpdate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();

		ToDoListDao toDoListDao = new ToDoListDao(em);
		toDoListDao.updateToDoList(2,"Liste 5.1",true);
		em.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
