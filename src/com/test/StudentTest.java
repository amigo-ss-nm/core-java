package com.test;

import java.util.List;

import org.junit.Test;

import com.dao.StudentDao;
import com.pojo.Student;
import com.pojo.StudentCondition;

public class StudentTest {

	private StudentDao studentDao=new StudentDao();
	@Test
	public void TestQuery() {
		StudentCondition condition = new StudentCondition();
		condition.setStudentNO(2018001);
		List<Student> list=studentDao.queryStudentByCondition(condition);
	}
}
