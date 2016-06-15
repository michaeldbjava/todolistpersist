package de.testdao.userentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.dao.UserDao;
import de.entity.user.User;

public class TestUserDaoRetriveWithTodolist {

	public TestUserDaoRetriveWithTodolist() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			UserDao userDao = new UserDao(em);
			User user = userDao.retrieveUser("michaellaube");
			System.out.println(user.toString());
			em.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
