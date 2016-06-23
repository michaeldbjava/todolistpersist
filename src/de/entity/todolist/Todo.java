package de.entity.todolist;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the todo database table.
 * 
 */
/**
 * @author michael
 * @version 0.1
 *
 */
@Entity
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	private boolean reminderon;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private String status;

	@Lob
	private String todo;

	@Lob
	private String todocontent;

	
//	private int todolistnr;

	//bi-directional many-to-one association to Todolist
	@ManyToOne
	@JoinColumn(name="todolistnr")
	
	private Todolist todolist;
	
	//bi-directional many-to-one association to Todo
	@OneToMany(mappedBy="todo",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<DocumentTodo> documenttodo = new ArrayList<DocumentTodo>();

	public Todo() {
	}

	
	
	/**
	 * Creates a new Todo object that represents a todo
	 * @param todo The headline of todo
	 * @param status The status of todo
	 * @param priority The priority of todo
	 * @param todocontent The content of todo
	 * @param creationdate The date of creation of todo
	 * @param startdate The date to start the todo
	 * @param enddate The date to end the todo
	 * @param lastmodifieddate The date of last modification of todo
	 * @param reminddate The date to remind to todo
	 * @param reminderon Set the reminder on
	 * @param todolist A Todolist object to assign this todo
	 * @param documenttodo List of documents to do
	 * 
	 * 
	 */
	
	public Todo(String todo, String status, String priority, String todocontent, Date creationdate, Date startdate,
			Date enddate, Date lastmodifieddate, Date reminddate, boolean reminderon, Todolist todolist,
			List<DocumentTodo> documenttodo) {
		super();
		this.todo = todo;
		this.status = status;
		this.priority = priority;
		this.todocontent = todocontent;
		this.creationdate = creationdate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.lastmodifieddate = lastmodifieddate;
		this.reminddate = reminddate;
		this.reminderon = reminderon;
		this.todolist = todolist;
		this.documenttodo = documenttodo;
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

	public boolean getReminderon() {
		return this.reminderon;
	}

	public void setReminderon(boolean reminderon) {
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

	/*public int getTodolistnr() {
		return this.todolistnr;
	}

	public void setTodolistnr(int todolistnr) {
		this.todolistnr = todolistnr;
	}*/
	
	public Todolist getTodolist() {
		return this.todolist;
	}

	public void setTodolist(Todolist todolist) {
		this.todolist = todolist;
	}

	public List<DocumentTodo> getDocumenttodo() {
		return documenttodo;
	}

	public void setDocumenttodo(List<DocumentTodo> documenttodo) {
		this.documenttodo = documenttodo;
	}



	@Override
	public String toString() {
		return "Todo [todonrabsolut=" + todonrabsolut + ", "
				+ (creationdate != null ? "creationdate=" + creationdate + ", " : "")
				+ (enddate != null ? "enddate=" + enddate + ", " : "")
				+ (lastmodifieddate != null ? "lastmodifieddate=" + lastmodifieddate + ", " : "")
				+ (priority != null ? "priority=" + priority + ", " : "")
				+ (reminddate != null ? "reminddate=" + reminddate + ", " : "") + "reminderon=" + reminderon + ", "
				+ (startdate != null ? "startdate=" + startdate + ", " : "")
				+ (status != null ? "status=" + status + ", " : "") + (todo != null ? "todo=" + todo + ", " : "")
				+ (todocontent != null ? "todocontent=" + todocontent + ", " : "")
				+ (todolist != null ? "todolist=" + todolist + ", " : "")
				+ (documenttodo != null ? "documenttodo=" + documenttodo : "") + "]";
	}
	
	

}