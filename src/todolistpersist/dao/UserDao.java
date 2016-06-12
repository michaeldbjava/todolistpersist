package todolistpersist.dao;

import java.util.List;

import javax.persistence.EntityManager;

import todolistpersist.entity.user.User;
import todolistpersist.entity.user.UserGroup;
import todolistpersist.entity.user.UserGroupPK;

public class UserDao {
	EntityManager em;
	public UserDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em=em;
	}
	
	public boolean addUser(String username, String lastname, String firstname, String adress, String e_mail, String fixnetwork,
			String mobilnetwork, String password, String passwordquestion, String passwordanswer){
		em.getTransaction().begin();
		User user = new User(username, lastname, firstname, adress, e_mail, fixnetwork, mobilnetwork, password, passwordquestion, passwordanswer);
		em.persist(user);
		em.getTransaction().commit();
		return false;
	}
	
	public boolean addUser(User user){
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return false;
	}
	
	public boolean updateUser(String username, String lastname, String firstname, String adress, String e_mail, String fixnetwork,
			String mobilnetwork, String password, String passwordquestion, String passwordanswer){
		em.getTransaction().begin();
		User user = em.find(User.class, username);
		user.setLastname(lastname);
		user.setFirstname(firstname);
		user.setAdress(adress);
		user.setE_mail(e_mail);
		user.setFixnetwork(fixnetwork);
		user.setMobilnetwork(mobilnetwork);
		user.setPassword(passwordanswer);
		user.setPasswordquestion(passwordquestion);
		user.setPasswordanswer(passwordanswer);
		em.getTransaction().commit();
		return false;
		
	}
	
	public boolean updateUser(User user){
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		return false;
	}
	
	public boolean deleteUser(String username){
		em.getTransaction().begin();
		User user = em.find(User.class, username);
		em.remove(user);
		em.getTransaction().commit();
		return false;
	}
	// delete mit user object
	
	
	public boolean deleteUser(User user){
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		return false;
	}
	public User retrieveUser(String username){
		User user = em.find(User.class, username);
		return user;

	}
	
	
	

}
