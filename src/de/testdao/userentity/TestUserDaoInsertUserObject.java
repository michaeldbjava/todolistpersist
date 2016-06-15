package de.testdao.userentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.dao.UserDao;
import de.entity.user.User;
import de.entity.user.UserGroup;

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
			User userToInsert = new User("heinz", "Laube", "Michael", "Herr", "michael@web.de", "0221/8888", "0178/8888", "secret", "Tier", "Tiger");
			User userToInsert2 = new User("michaellaube", "Laube", "Michael", "Herr", "michael@web.de", "0221/8888", "0178/8888", "secret", "Tier", "Tiger");
			
			/*Test 2, einen neuen Nutzer mit einer neuen Nutzergruppe hinzufügen
			 * 
			 */
			UserGroup userGroup = new UserGroup("gruppexx",userToInsert);
			userToInsert.getUserGroups().add(userGroup);
			userToInsert2.getUserGroups().add(userGroup);
			userDao.addUser(userToInsert);
			userDao.addUser(userToInsert2);
			em.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}

}
