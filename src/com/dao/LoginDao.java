package com.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.pojo.User;

    /**
    * @ClassName: LoginDao
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author nieming
    * @date 2020年6月22日
    *
    */  
public class LoginDao {
	  
	
	    /**
	    * @Fields flag : TODO(用一句话描述这个变量表示什么)
	    */
	public int flag=0;
	
	//初始一个Log4j的对象
	static Logger log4j=Logger.getLogger(LoginDao.class);
	
	@Test
	public void minus() {
		int a=10;
		int b=5;
		int c=a+b;
		String hello="hello";
		String word="word";
		boolean flag=true;
		assertTrue(flag);//判断boolean类型数据是否为true
		//assertEquals("word1", word);//判断string是否相同
		//assertNotNull(hello);//判断对象是否为空
		//assertEquals(c, 10);//判断是否相同
		System.out.println(a+b);
	}
	
	@Before
	public void beforeTest() {
		System.out.println("执行before方法");
		//做一些资源准备工作
		//或者在所有的测试方法执行之前，都要执行的一些工作。
		//修改代码
		//修改代码2
		
	}
	@After
	public void afterTest() {
		System.out.println("执行after方法");
		//做一些资源释放的工作
	}
	@Test
	@Ignore
	public void testTwo() {
		System.out.println("执行TestTwo");
	}
	
	@Test
	public void checkNameAndPassword() {
		
		System.out.println("执行checkNameAndPassword");
		User user=new User();
		user.setUserName("admin");
		user.setPassword("123456");
		
		int salary=10000;
		//代码的逻辑
		System.out.println("xxxxx");
		
		log4j.debug("调试信息");
		log4j.info("业务信息");
		log4j.warn("告警信息");//在系统运行中,warning的日志不会阻止项目的运行。
		
		//用户名密码校验
		if("admin".equals(user.getUserName())&& 
				"123456".equals(user.getPassword())) {
			
			System.out.println("登陆成功");
			
			if(salary>=1000000) {
				System.out.println("迎娶白富美");
			}
			else if(salary>=100000 && salary<1000000) {
				System.out.println("迎娶白美");
			}
			else if(salary>=20000 && salary<1000000) {
				System.out.println("迎娶美");
			}
			else if(salary>=10000 && salary<20000) {
				System.out.println("迎娶白");
			}
			else {
				System.out.println("迎娶女的，活的");
			}
		}
		
		try {
			
		}catch (Exception e) {
			log4j.error(e.getMessage());
		}
	}
}
