package de.testdao.userentity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dao.UserDao;
import de.entity.user.User;

public class TestUserDeleteEntity {

	public TestUserDeleteEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testDeleteUserEntity() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser("ralf6");
		boolean statusDelete = userDao.deleteUser(user);
		
		em.close();
		assertEquals(true, statusDelete);
	}

	

}
