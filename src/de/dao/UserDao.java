package de.dao;

import java.util.List;

import javax.persistence.EntityManager;

import de.entity.user.User;
import de.entity.user.UserGroup;
import de.entity.user.UserGroupPK;

public class UserDao {
	EntityManager em;

	public UserDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

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
	// delete mit user object

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
	
	public User retrieveUser(String username) {
		em.getTransaction().begin();
		User user = null;
		if (username != null) {
			user = em.find(User.class, username);
		}
		em.getTransaction().commit();
		return user;

	}

}
