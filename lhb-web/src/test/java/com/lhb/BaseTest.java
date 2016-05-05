package com.lhb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-config.xml","/spring/spring-mvc.xml" })
public class BaseTest {
	protected static Log logger = LogFactory.getLog(BaseTest.class);
	@Before
	public void setUp() throws Exception {
		System.out.println("--Before--");

	}
	@After
	public void testAfter() throws Exception {
		System.out.println("--end--");

	}
}

