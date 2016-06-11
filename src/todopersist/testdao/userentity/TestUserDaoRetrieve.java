package todopersist.testdao.userentity;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import todolistpersist.User;
import todolistpersist.dao.UserDao;

public class TestUserDaoRetrieve {

	public TestUserDaoRetrieve() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			//EntityGraph entityGraph=em.getEntityGraph("User.userGroups");
			
			UserDao userDao = new UserDao(em);
			User user = userDao.retrieveUser("ralf1");
			//System.out.println(user.getUserGroups().get(0).getId().getGroupname());
			System.out.println(user.toString());
			}
			catch(Exception e){
				e.printStackTrace();
			}

	}

}
