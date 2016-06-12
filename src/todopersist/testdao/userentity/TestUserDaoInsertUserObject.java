package todopersist.testdao.userentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import todolistpersist.dao.UserDao;
import todolistpersist.entity.user.User;
import todolistpersist.entity.user.UserGroup;

public class TestUserDaoInsertUserObject {

	public TestUserDaoInsertUserObject() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			UserDao userDao = new UserDao(em);
			// Test 1, nur einen neuen Nutzer hinzufügen
			User userToInsert = new User("michaellaube3", "Laube", "Michael", "Herr", "michael@web.de", "0221/8888", "0178/8888", "secret", "Tier", "Tiger");
			
			/*Test 2, einen neuen Nutzer mit einer neuen Nutzergruppe hinzufügen
			 * 
			 */
			UserGroup userGroup = new UserGroup("gruppexx",userToInsert);
			userToInsert.getUserGroups().add(userGroup);
			
			userDao.addUser(userToInsert);
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}

}
