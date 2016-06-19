package de.testdao.userentity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dao.UserDao;
import de.entity.user.User;

public class TestUserUpdateEntity {

	public TestUserUpdateEntity() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testUpdateWithUserName() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		User user  = userDao.retrieveUser("heinz2");
		user.setFirstname("Der tolle Heinz2");
		boolean statusUpdate = userDao.updateUser(user);
		em.close();
		
		assertEquals(true, statusUpdate);
	}
}
