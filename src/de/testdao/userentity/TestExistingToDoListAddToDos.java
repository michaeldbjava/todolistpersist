/**
 * 
 */
package de.testdao.userentity;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dao.UserDao;
import de.entity.todolist.Todo;
import de.entity.todolist.Todolist;
import de.entity.user.User;

/**
 * @author michael
 *
 */
public class TestExistingToDoListAddToDos {

	@Test
	public void test() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser("heinz40");
		List<Todolist> toDoList = user.getTodolists();
		for(Todolist todolist:toDoList){
			System.out.println(todolist.toString());
			Todo toDo1 = new Todo();
			toDo1.setTodo("ToDo 1");
			Todo toDo2 = new Todo();
			toDo2.setTodo("ToDo 2");
			Todo toDo3 = new Todo();
			toDo3.setTodo("ToDo 3");
			todolist.addTodo(toDo3);
			todolist.addTodo(toDo2);
			todolist.addTodo(toDo1);
		}
		boolean statusAddTodos= userDao.updateUser(user);
		em.close();
		assertTrue(statusAddTodos);
	}

}
