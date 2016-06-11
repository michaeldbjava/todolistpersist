package todolistpersist.dao;

import javax.persistence.EntityManager;

import todolistpersist.User;
import todolistpersist.UserGroup;

public class UserGroupDao {
EntityManager em;
	public UserGroupDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em=em;
	}
	
	public boolean addUserGroup(String usergroup,User user){
			em.getTransaction().begin();
			UserGroup usergroup2 = new UserGroup(usergroup,user);
			em.persist(usergroup2);
			em.getTransaction().commit();
		return false;
	}
	
	public boolean addUserGroup(UserGroup usergroup){
		em.getTransaction().begin();
		em.persist(usergroup);
		em.getTransaction().commit();
		return false;
	}
	
	public boolean updateUserGroup(String usergroup,String username){
		return false;
	}
	
	public boolean updateUserGroup(UserGroup usergroup){
		return false;
	}

}
