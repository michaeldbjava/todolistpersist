package de.dao;

import java.util.List;

import javax.persistence.EntityManager;

import de.entity.user.User;
import de.entity.user.UserGroup;
import de.entity.user.UserGroupPK;
/**
 * 
 * @author michael
 * @version 0.1
 *
 */
public class UserDao {
	/**
	 * JPA EntityManager object
	 */
	EntityManager em;
/**
 * Creates a new UserDao object. 
 * @param em An EntityManager Object
 */
	public UserDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
/**
 * 
 * @param username The username
 * @param lastname The lastname
 * @param firstname The firstname
 * @param adress The adress
 * @param e_mail The e-Mail adress
 * @param fixnetwork The fixnetwork number
 * @param mobilnetwork The mobilnetwork number
 * @param password Password of user
 * @param passwordquestion Password question for password
 * @param passwordanswer Password answer for password question
 * @return
 */
	public boolean addUser(String username, String lastname, String firstname, String adress, String e_mail,
			String fixnetwork, String mobilnetwork, String password, String passwordquestion, String passwordanswer) {
		boolean statusAdd = false;
		em.getTransaction().begin();
		if (username != null) {
			User user = new User(username, lastname, firstname, adress, e_mail, fixnetwork, mobilnetwork, password,
					passwordquestion, passwordanswer);
			if (!em.contains(user)) {
				em.persist(user);
				statusAdd = true;
			}
		}
		em.getTransaction().commit();
		return statusAdd;
	}

	/**
	 * 
	 * @param user An object of type User
	 * @return Returns true if new user could be added to database
	 */
	public boolean addUser(User user) {
		boolean statusAdd = false;
		if (user.getUsername() != null) {
			em.getTransaction().begin();
			if (user != null) {
				if (!em.contains(user)) {
					
					em.persist(user);
					statusAdd = true;
				}
			}

			em.getTransaction().commit();
		}
		return statusAdd;
	}
	
	
	/**
	 * 
	 * @param username The username
	 * @param lastname The lastname
	 * @param firstname The firstname
	 * @param adress The adress
	 * @param e_mail The e-Mail adress
	 * @param fixnetwork The fixnetwork number
	 * @param mobilnetwork The mobilnetwork number
	 * @param password Password of user
	 * @param passwordquestion Password question for password
	 * @param passwordanswer Password answer for password question
	 * @return
	 */

	public boolean updateUser(String username, String lastname, String firstname, String adress, String e_mail,
			String fixnetwork, String mobilnetwork, String password, String passwordquestion, String passwordanswer) {
		boolean statusUpdate = false;
		em.getTransaction().begin();
		if (username != null) {
			User user = em.find(User.class, username);
			if (user != null) {
				user.setLastname(lastname);
				user.setFirstname(firstname);
				user.setAdress(adress);
				user.setE_mail(e_mail);
				user.setFixnetwork(fixnetwork);
				user.setMobilnetwork(mobilnetwork);
				user.setPassword(passwordanswer);
				user.setPasswordquestion(passwordquestion);
				user.setPasswordanswer(passwordanswer);
				statusUpdate = true;
			}
		}
		em.getTransaction().commit();
		return statusUpdate;

	}

	/**
	 * 
	 * @param user User to update
	 * @return Return true if user object could be successfully updated
	 */
	public boolean updateUser(User user) {
		boolean statusUpdate = false;
		em.getTransaction().begin();
		if (em.contains(user)) {
			em.merge(user);
			statusUpdate=true;
		}
		em.getTransaction().commit();
		return statusUpdate;
	}
	
	/**
	 * 
	 * @param username Username of user who should be deleted
	 * @return Returns true if User object could be successfully deleted
	 */

	public boolean deleteUser(String username) {
		em.getTransaction().begin();
		boolean statusDelete = false;
		if (username != null) {
			User user = em.find(User.class, username);
			if (user != null) {
				em.remove(user);
				statusDelete = true;
			}
		}
		em.getTransaction().commit();
		return statusDelete;
	}

	/**
	 * 
	 * @param user User object which will be deleted
	 * @return Returns true if delete operation was successfully
	 */
	public boolean deleteUser(User user) {
		em.getTransaction().begin();
		boolean statusDelete = false;
		if (user != null) {
			if(em.contains(user)){
				em.remove(user);
				statusDelete = true;
			}
		}
		em.getTransaction().commit();
		return statusDelete;
	}
	
	/**
	 * 
	 * @param username Name as Type String of user to retrieve as User object
	 * @return Return true if User retrieved successfully
	 */
	
	public User retrieveUser(String username) {
		em.getTransaction().begin();
		User user = null;
		if (username != null) {
			user = em.find(User.class, username);
		}
		em.getTransaction().commit();
		return user;

	}
	
	/**
	 * 
	 * @param userToFind User object which should be retrieved as User object
	 * @return
	 */
	
	public User retrieveUser(User userToFind) {
		em.getTransaction().begin();
		User user = null;
		if (userToFind.getUsername() != null) {
			user = em.find(User.class, userToFind.getUsername());
		}
		em.getTransaction().commit();
		return user;

	}

}
