package com.lhb;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-config.xml","/spring/spring-mvc.xml" })
public class BaseTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("--Before--");

	}
	@After
	public void testAfter() throws Exception {
		System.out.println("--end--");

	}
}

