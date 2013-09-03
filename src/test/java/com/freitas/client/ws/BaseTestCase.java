package com.freitas.client.ws;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-ws-client.xml"})
public class BaseTestCase extends Assert implements ApplicationContextAware {
	
	protected ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext ac) 
			throws BeansException{
		this.applicationContext = ac;
	}

}
