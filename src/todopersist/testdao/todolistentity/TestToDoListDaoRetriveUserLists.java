package todopersist.testdao.todolistentity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import todolistpersist.dao.ToDoListDao;
import todolistpersist.entity.todolist.Todolist;

public class TestToDoListDaoRetriveUserLists {

	public TestToDoListDaoRetriveUserLists() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		
		ToDoListDao todolistDao = new ToDoListDao(em);
		List<Todolist> listTodolists = todolistDao.retrieveUserTodolists("michaellaube");
		
		for(Todolist list:listTodolists){
			System.out.println(list.getUser().toString());
			System.out.println(list.getUser().getUserGroups().toString());
		}

	}

}
