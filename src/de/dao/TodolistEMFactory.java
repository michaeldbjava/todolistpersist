package de.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * 
 * @author michael
 * @version 0.1
 *
 */
public class TodolistEMFactory {

	
/**
 * This class creates an EntityManager object.
 * @param persistContext
 * @return A new JPA EntityManaager object.
 */
	public static EntityManager createEM(String persistContext){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
