package de.testdao.userentity;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dao.UserDao;
import de.entity.user.User;

public class TestUserRetrive {

	@Test
	public void testRetriveUserString() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser("heinz40");
		System.out.println(user.toString());
		assertEquals("heinz40", user.getUsername());
		em.close();
	}

}
