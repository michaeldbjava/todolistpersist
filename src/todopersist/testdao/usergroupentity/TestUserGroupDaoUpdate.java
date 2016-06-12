package todopersist.testdao.usergroupentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import todolistpersist.dao.UserGroupDao;
import todolistpersist.entity.user.User;
import todolistpersist.entity.user.UserGroup;
import todolistpersist.entity.user.UserGroupPK;

public class TestUserGroupDaoUpdate {

	public TestUserGroupDaoUpdate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			
			
			UserGroupDao userDao = new UserGroupDao(em);
			// Test 1, nur einen neuen Nutzer hinzufügen
			User userToInsert = new User("ralf1", "Mustermann", "Frank", "Herr", "frank@web.de", "0221/8888", "0178/8888", "secret", "Tier", "Tiger");
			
			/*Test 2, einen neuen Nutzer mit einer neuen Nutzergruppe hinzufügen
			 * 
			 */
			UserGroup userGroup = new UserGroup("todolist",userToInsert);
			userGroup.setUser(userToInsert);
			UserGroupPK userGroupPk = new UserGroupPK("todolist2", "ralf1");
			userGroup.setId(userGroupPk);
			
			userDao.updateUserGroup(userGroup);
			
			}
			catch(Exception e){
				e.printStackTrace();
			}


	}

}
