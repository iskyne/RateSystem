package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import service.RateService;
import service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class testUserService {
	@Autowired
	UserService us;
	@Autowired
	RateService rs;
	
	@Test
	public void findMatchUser(){
		assertTrue(us.isValidUser("admin", "123456"));
	}
	/*
	 
	@Test
	public void show(){
		List<String> rslt=rs.getRatingDetail(1);
		for(String str:rslt){
			System.out.println(str);
		}
	}
	*/
	@Test
	public void testAddUser(){
		assertTrue(us.addUser("lisi", "123456"));
		assertTrue(us.addUser("lisi", "123456"));
	}
}
