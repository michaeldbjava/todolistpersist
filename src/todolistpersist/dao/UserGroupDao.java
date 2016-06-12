package todolistpersist.dao;

import javax.persistence.EntityManager;

import todolistpersist.entity.user.User;
import todolistpersist.entity.user.UserGroup;
import todolistpersist.entity.user.UserGroupPK;

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
	
	
	
	public boolean updateUserGroup(UserGroup usergroup){
		em.getTransaction().begin();
		em.merge(usergroup);
		em.getTransaction().commit();
		return false;
	}
	
	public boolean deleteUserGroup(UserGroup usergroup){
		em.getTransaction().begin();
		UserGroup usergroupToDelete = em.find(UserGroup.class, usergroup.getId());
		em.remove(usergroupToDelete);
		em.getTransaction().commit();
		return false;
	}

}
