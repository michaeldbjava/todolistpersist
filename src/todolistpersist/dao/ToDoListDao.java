package todolistpersist.dao;

import java.util.List;

import javax.persistence.EntityManager;

import todolistpersist.entity.todolist.Todolist;
import todolistpersist.entity.user.User;

public class ToDoListDao {
	EntityManager em;
	public ToDoListDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em=em;
	}

	public boolean addToDoList(String todolist,String username,boolean visible){
		em.getTransaction().begin();
		User user = em.find(User.class, username);
		
		Todolist todolistNew = new Todolist(todolist,visible);
		javax.persistence.Query queryMax = em.createNamedQuery("Todolist.findMaxKey");
		Integer maxKeyValue = (Integer)queryMax.getSingleResult();
		todolistNew.setTodolistnr(maxKeyValue+1);
		todolistNew.setTodolist(todolist);
		todolistNew.setUser(user);
		todolistNew.setVisible(visible);
		em.persist(todolistNew);
		em.getTransaction().commit();
		return false;
	}

	
	public Todolist retrieveTodolist(int todolistNr){
		em.getTransaction().begin();
		Todolist todolist = em.find(Todolist.class, todolistNr);
		em.getTransaction().commit();
		return todolist;
	}
	
	public List<Todolist> retrieveUserTodolists(String username){
//		Todolist.findUserTodolists
		em.getTransaction().begin();
		javax.persistence.Query query = em.createNamedQuery("Todolist.findUserTodolists");
		query.setParameter("username", username);
		
		List<Todolist> resultlist = query.getResultList();
		em.getTransaction().commit();
		return resultlist;
	}
	public boolean updateToDoList(Todolist todolist){
		em.getTransaction().begin();
		em.merge(todolist);
		em.getTransaction().commit();
		return false;
		
	}
	
	
	
	public boolean deleteToDoList(){
		em.getTransaction().begin();
		em.getTransaction().commit();
		return false;
	}

}
