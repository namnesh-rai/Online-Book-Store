package com.bookstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class CategoryTest {

	public static void main(String[] args) {
	  Category cat = new Category("love is in the air");
		
		
	  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	  EntityManager entityManager = entityManagerFactory.createEntityManager();
	  
	  entityManager.getTransaction().begin();
	  
	  entityManager.persist(cat);
	  
	  entityManager.getTransaction().commit();
	  entityManager.close();
	  entityManagerFactory.close();
	  
	  System.out.println("a cat object was persisted");
	}

}
