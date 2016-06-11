package todopersist.testdao.userentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import todolistpersist.dao.UserDao;

public class TestUserDaoDelete {

	public TestUserDaoDelete() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			UserDao userDao = new UserDao(em);
			userDao.deleteUser("ralf2");
			}
			catch(Exception e){
				e.printStackTrace();
			}


	}

}
