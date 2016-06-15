package de.dao;

import javax.persistence.EntityManager;

import de.entity.user.User;
import de.entity.user.UserGroup;
import de.entity.user.UserGroupPK;

public class UserGroupDao {
	EntityManager em;

	public UserGroupDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}

	public boolean addUserGroup(String usergroup, User user) {
		em.getTransaction().begin();
		if (usergroup != null && user != null) {
			UserGroup usergroup2 = new UserGroup(usergroup, user);
			em.persist(usergroup2);
		}
		em.getTransaction().commit();
		return false;
	}

	public boolean addUserGroup(UserGroup usergroup) {
		em.getTransaction().begin();
		if (usergroup != null) {
			em.persist(usergroup);
		}
		em.getTransaction().commit();
		return false;
	}

	public boolean updateUserGroup(UserGroup usergroup) {
		em.getTransaction().begin();
		if (usergroup != null) {
			em.merge(usergroup);
		}
		em.getTransaction().commit();
		return false;
	}

	public boolean deleteUserGroup(UserGroup usergroup) {
		em.getTransaction().begin();
		if (usergroup != null) {
			UserGroup usergroupToDelete = em.find(UserGroup.class, usergroup.getId());
			em.remove(usergroupToDelete);
		}
		em.getTransaction().commit();
		return false;
	}

}
