package de.entity.user;

import java.io.Serializable;
import javax.persistence.*;

import de.entity.todolist.Todolist;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
/**
 * @author michael
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")

})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String adress;

	@Column(name = "`e-mail`")
	private String e_mail;

	private String firstname;

	private String fixnetwork;

	private String lastname;

	private String mobilnetwork;

	private String password;

	@Lob
	private String passwordanswer;

	@Lob
	private String passwordquestion;

	// bi-directional many-to-one association to Todolist
	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Todolist> todolists = new ArrayList<Todolist>();

	// bi-directional many-to-one association to UserGroup
	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<UserGroup> userGroups = new ArrayList<UserGroup>();

	public User() {
	}

	/**
	 * Create a new User object, which respresent a new user to ToDoList applicatioin
	 * @param username
	 * @param lastname
	 * @param firstname
	 * @param adress
	 * @param e_mail
	 * @param fixnetwork
	 * @param mobilnetwork
	 * @param password
	 * @param passwordquestion
	 * @param passwordanswer
	 */
	public User(String username, String lastname, String firstname, String adress, String e_mail, String fixnetwork,
			String mobilnetwork, String password, String passwordquestion, String passwordanswer) {

		this.username = username;
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.e_mail = e_mail;
		this.fixnetwork = fixnetwork;
		this.mobilnetwork=mobilnetwork;
		this.password=password;
		this.passwordquestion=passwordquestion;
		this.passwordanswer=passwordanswer;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getE_mail() {
		return this.e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFixnetwork() {
		return this.fixnetwork;
	}

	public void setFixnetwork(String fixnetwork) {
		this.fixnetwork = fixnetwork;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobilnetwork() {
		return this.mobilnetwork;
	}

	public void setMobilnetwork(String mobilnetwork) {
		this.mobilnetwork = mobilnetwork;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordanswer() {
		return this.passwordanswer;
	}

	public void setPasswordanswer(String passwordanswer) {
		this.passwordanswer = passwordanswer;
	}

	public String getPasswordquestion() {
		return this.passwordquestion;
	}

	public void setPasswordquestion(String passwordquestion) {
		this.passwordquestion = passwordquestion;
	}

	public List<Todolist> getTodolists() {
		return this.todolists;
	}

	public void setTodolists(List<Todolist> todolists) {
		this.todolists = todolists;
	}

	public Todolist addTodolist(Todolist todolist) {
		getTodolists().add(todolist);
		todolist.setUser(this);

		return todolist;
	}

	public Todolist removeTodolist(Todolist todolist) {
		getTodolists().remove(todolist);
		todolist.setUser(null);

		return todolist;
	}

	public List<UserGroup> getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	/*
	 * Das ist Unfug. Über ein User objekt muss man sich einfach die User List besorgen
	 * und dann einfach das UserGroup Objekt hinzufügen
	 * public UserGroup addUserGroup(UserGroup userGroup) {
		getUserGroups().add(userGroup);
		userGroup.setUser(this);

		return userGroup;
	}*/

	/*
	 * Hier gilt das Gleiche ...
	 */
	public UserGroup removeUserGroup(UserGroup userGroup) {
		getUserGroups().remove(userGroup);
		userGroup.setUser(null);

		return userGroup;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", adress=" + adress + ", e_mail=" + e_mail + ", firstname=" + firstname
				+ ", fixnetwork=" + fixnetwork + ", lastname=" + lastname + ", mobilnetwork=" + mobilnetwork
				+ ", password=" + password + ", passwordanswer=" + passwordanswer + ", passwordquestion="
				+ passwordquestion + ", todolists=" + todolists + ", userGroups=" + userGroups + "]";
	}
	
	

}