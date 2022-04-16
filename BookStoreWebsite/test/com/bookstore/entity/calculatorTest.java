package com.bookstore.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class calculatorTest {

	@Test
	public void testAdd() {
		calculator calc = new calculator();
		int a = 1234;
		int b = 5678;
		int result = calc.add(a,b);
		
		int expected = 6912;
		
		assertEquals(expected,result);
		
		
		
	}

}
