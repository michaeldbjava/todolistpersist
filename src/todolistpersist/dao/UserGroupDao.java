package todolistpersist.dao;

import javax.persistence.EntityManager;

import todolistpersist.UserGroup;

public class UserGroupDao {
EntityManager em;
	public UserGroupDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em=em;
	}
	
	public boolean addUserGroup(String usergroup,String username){
		return false;
	}
	
	public boolean addUserGroup(UserGroup usergroup){
		return false;
	}
	
	public boolean updateUserGroup(String usergroup,String username){
		return false;
	}
	
	public boolean updateUserGroup(UserGroup usergroup){
		return false;
	}

}
