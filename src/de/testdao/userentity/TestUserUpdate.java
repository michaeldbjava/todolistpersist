package de.testdao.userentity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dao.UserDao;

public class TestUserUpdate {

	public TestUserUpdate() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testUpdateWithUserName() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		boolean statusUpdate = userDao.updateUser("heinz2","Noch eine Änderung","Ralf","Herr","ernstralf@testtest.de","0221/54545","0178/888","geheim","Geburtsort?","Köln");
		em.close();
		
		assertEquals(true, statusUpdate);
	}
}
