package de.testdao.userentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.dao.UserDao;

public class TestUserDaoDelete {

	public TestUserDaoDelete() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			UserDao userDao = new UserDao(em);
			userDao.deleteUser("michaellaube");
			em.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}


	}

}
