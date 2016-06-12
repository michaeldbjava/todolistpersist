package todopersist.testdao.userentity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import todolistpersist.dao.UserDao;
import todolistpersist.entity.user.User;

public class TestUserDaoInsert {

	public TestUserDaoInsert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			UserDao userDao = new UserDao(em);
			userDao.addUser("ralf2","Müller","Ralf","Herr","ralf@testtest.de","0221/54545","0178/888","geheim","Geburtsort?","Köln");
			
			}
			catch(Exception e){
				e.printStackTrace();
			}

	}

}
