package todopersist.testdao.userentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import todolistpersist.dao.UserDao;

public class TestUserDaoUpdate {

	public TestUserDaoUpdate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			UserDao userDao = new UserDao(em);
			userDao.updateUser("ralf2","Ernst","Ralf","Herr","ernstralf@testtest.de","0221/54545","0178/888","geheim","Geburtsort?","Köln");
			
			}
			catch(Exception e){
				e.printStackTrace();
			}

	}

}
