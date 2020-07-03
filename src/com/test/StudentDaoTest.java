package com.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.dao.StudentDao;
import com.pojo.Student;

public class StudentDaoTest {

	private StudentDao studentDao=new StudentDao();
	
	    /**
	    * @Title: testQueryAllStudent
	    * @Description: 测试查询所有的学生信息
	    * @param     参数
	    * @return void    返回类型
	    * @throws
	    */
	    
	@Test
	public void testQueryAllStudent() {
		List<Student> studentList = 
				studentDao.queryAllStudent();
		assertEquals(49, studentList.size());
	}
	@Test
	public void testInsertStudent() {
		Student student=new Student();
		student.setStudentNO(20180009);
		student.setStudentName("shuaige");
		student.setGrade("2018级3班");
		student.setSchool("吉首大学");
		int num=studentDao.insertStudent(student);
		assertEquals(1, num);
	}
	
	@Test
	public void testDelete() {
		int num=studentDao.deleteStudent();
		assertEquals(49, num);
	}
}
