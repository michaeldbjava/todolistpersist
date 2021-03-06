package de.testdao.userentity;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dao.UserDao;

public class TestUserDelete {

	@Test
	public void testDeleteUserString() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		boolean statusDelete = userDao.deleteUser("michaellaube");
		
		em.close();
		assertEquals(true, statusDelete);
	}

	
}
