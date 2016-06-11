package todolistpersist.dao;

import javax.management.Query;
import javax.persistence.EntityManager;

import todolistpersist.Todolist;

public class ToDoListDao {
	EntityManager em;
	public ToDoListDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em=em;
	}

	public boolean addToDoList(String todolist,byte visible){
		em.getTransaction().begin();
		Todolist todolistNew = new Todolist(todolist,visible);
		javax.persistence.Query queryMax = em.createNamedQuery("Todolist.findMaxKey");
		em.getTransaction().commit();
		return false;
	}
	
	public boolean updateToDoList(){
		em.getTransaction().begin();
		em.getTransaction().commit();
		return false;
		
	}
	
	public boolean deleteToDoList(){
		em.getTransaction().begin();
		em.getTransaction().commit();
		return false;
	}

}
