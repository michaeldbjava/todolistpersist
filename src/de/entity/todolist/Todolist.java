package de.entity.todolist;

import java.io.Serializable;
import javax.persistence.*;

import de.entity.user.User;

import java.util.List;


/**
 * The persistent class for the todolist database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t"),
@NamedQuery(name="Todolist.findUserTodolists", query="SELECT t FROM Todolist t where t.user.username=:username"),
@NamedQuery(name="Todolist.findOneUserTodolist", query="SELECT t FROM Todolist t where t.user.username=:username and t.todolist=:todolist"),
@NamedQuery(name="Todolist.findOneTodolist", query="SELECT t FROM Todolist t where t.todolistnr=:todolistnr"),
@NamedQuery(name="Todolist.findMaxKey", query="SELECT max(t.todolistnr) FROM Todolist t")
})
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int todolistnr;

	@Lob
	private String todolist;

	private boolean visible;

	//bi-directional many-to-one association to Todo
	@OneToMany(mappedBy="todolist",fetch=FetchType.EAGER)
	private List<Todo> todos;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="fk_user_username")
	private User user;

	public Todolist() {
	}

	public Todolist(String todolist,boolean visible) {
		this.todolist=todolist;
		this.visible=visible;
	}
	
	public int getTodolistnr() {
		return this.todolistnr;
	}

	public void setTodolistnr(int todolistnr) {
		this.todolistnr = todolistnr;
	}

	public String getTodolist() {
		return this.todolist;
	}

	public void setTodolist(String todolist) {
		this.todolist = todolist;
	}

	public boolean getVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public List<Todo> getTodos() {
		return this.todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public Todo addTodo(Todo todo) {
		getTodos().add(todo);
		todo.setTodolist(this);

		return todo;
	}

	public Todo removeTodo(Todo todo) {
		getTodos().remove(todo);
		todo.setTodolist(null);

		return todo;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Todolist [todolistnr=" + todolistnr + ", todolist=" + todolist + ", visible=" + visible +  "]";
	}
	
	

}