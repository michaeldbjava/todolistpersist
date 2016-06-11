package todolistpersist;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the todo database table.
 * 
 */
@Entity
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int todonrabsolut;

	@Temporal(TemporalType.DATE)
	private Date creationdate;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Temporal(TemporalType.DATE)
	private Date lastmodifieddate;

	private String priority;

	@Temporal(TemporalType.DATE)
	private Date reminddate;

	private byte reminderon;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private String status;

	@Lob
	private String todo;

	@Lob
	private String todocontent;

	private int todonrtodolist;

	//bi-directional many-to-one association to Todolist
	@ManyToOne
	@JoinColumn(name="fk_todolistnr")
	private Todolist todolist;

	public Todo() {
	}

	public int getTodonrabsolut() {
		return this.todonrabsolut;
	}

	public void setTodonrabsolut(int todonrabsolut) {
		this.todonrabsolut = todonrabsolut;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getLastmodifieddate() {
		return this.lastmodifieddate;
	}

	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getReminddate() {
		return this.reminddate;
	}

	public void setReminddate(Date reminddate) {
		this.reminddate = reminddate;
	}

	public byte getReminderon() {
		return this.reminderon;
	}

	public void setReminderon(byte reminderon) {
		this.reminderon = reminderon;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTodo() {
		return this.todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getTodocontent() {
		return this.todocontent;
	}

	public void setTodocontent(String todocontent) {
		this.todocontent = todocontent;
	}

	public int getTodonrtodolist() {
		return this.todonrtodolist;
	}

	public void setTodonrtodolist(int todonrtodolist) {
		this.todonrtodolist = todonrtodolist;
	}

	public Todolist getTodolist() {
		return this.todolist;
	}

	public void setTodolist(Todolist todolist) {
		this.todolist = todolist;
	}

}