package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest extends BaseDAOTest{
	private static UserDAO userDAO;
    
	@BeforeClass
	public static void setUpClass() throws Exception {
//		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
//		entityManager = entityManagerFactory.createEntityManager();
		BaseDAOTest.setUpBeforeClass();
		userDAO = new UserDAO(entityManager);
	}
	@Test
	public void testCreateUsers() {
		 Users user1 = new Users();
		  user1.setEmail("Tarunesh");
		  user1.setFullName("vasu");
		  user1.setPassword("vasu@13");
		  
		  user1 = userDAO.create(user1);
		  
		  
		  assertTrue(user1.getUserId()>0);
	}
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFileldNotSet() {
		Users user1 = new Users();
		user1 = userDAO.create(user1);
		
	assertTrue(user1.getUserId()>0);
	}
	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("namnesh.rai@gmail.com");
		user.setFullName("Namnesh Rai");
		user.setPassword("secret");
		
		userDAO.update(user);
		String expected = "secret";
		String actual = user.getPassword();
		assertEquals(expected,actual);
		
		
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if(user!=null)
		System.out.println(user.getEmail());
		assertNotNull(user);
	}
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	@Test
	public void testDeleteUsers() {
		Integer userId = 5;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistingUsers() {
		Integer userId = 5;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users>listUsers = userDAO.listAll();
		assertTrue(listUsers.size()>0);
	}
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		assertEquals(9,totalUsers);
	}
	@Test
	public void testFindByEmail() {
		String email = "ravina@gmail.com";
		Users user = userDAO.findByEmail(email);
		
		assertNotNull(user);
	}
	@AfterClass
	public static void tearDownClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
