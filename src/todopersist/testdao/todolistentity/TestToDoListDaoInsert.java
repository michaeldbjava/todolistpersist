package todopersist.testdao.todolistentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import todolistpersist.dao.ToDoListDao;

public class TestToDoListDaoInsert {

	public TestToDoListDaoInsert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();

		ToDoListDao toDoListDao = new ToDoListDao(em);
		toDoListDao.addToDoList("Liste 5", "michaellaube", true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
