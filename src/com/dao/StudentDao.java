package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pojo.Student;
import com.pojo.StudentCondition;

/**
    * @ClassName: StudentDao
    * @Description: 学生信息的数据库操作
    * @author nieming
    * @date 2020年6月23日
    *
    */
    
public class StudentDao {
	private final static String url="jdbc:mysql://localhost:3306/core-java?useUnicode=true&characterEncoding=UTF-8";
	private final static String username="root";
	private final static String password="123456";
	
	    /**
	    * @Title: getConnection
	    * @Description: 获取数据库连接
	    * @param @return
	    * @param @throws Exception    参数
	    * @return Connection    返回类型
	    * @throws
	    */
	    
	public Connection getConnection() throws Exception{
		//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				
				//获取连接
				Connection connection = DriverManager.getConnection(url, username, password);
				return connection;
	}
	
	public int insertStudent(Student student) {
		/*
		 * JDBC开发步骤
		 * 1：加载驱动
		 * 2. 获取连接
		 * 3.创建statement
		 * 4.执行语句
		 * 5.处理结果
		 * 6.释放资源
		 * 
		 * */
		PreparedStatement pst=null;
		Connection connection=null;
		int num=0;
		try {
		
		 connection = getConnection();
		String sql="insert into studentinfo values(?,?,?,?);";
		
		//创建statement
		 pst = connection.prepareStatement(sql);
		pst.setInt(1, student.getStudentNO());//设置sql语句中的占位符的值
		pst.setString(2,student.getStudentName());
		pst.setString(3, student.getGrade());
		pst.setString(4, student.getSchool());
		//执行语句:如果是增删，改--》insert/update/delete语句。使用executeUpate();
		//一般不需要处理返回结果
		num=pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			//在finally里面释放资源
			try {
				pst.close();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return num;
		
	}
	public void modifyStudent() {}
	public int deleteStudent() {
		PreparedStatement pst=null;
		Connection connection=null;
		int num=0;
		try {
		
		 connection = getConnection();
		String sql="delete from studentInfo;";
		
		//创建statement
		 pst = connection.prepareStatement(sql);

		//执行语句:如果是增删，改--》insert/update/delete语句。使用executeUpate();
		//一般不需要处理返回结果
		num=pst.executeUpdate();//返回的是受影响的数据数量
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			//在finally里面释放资源
			try {
				pst.close();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return num;
	}
	//通过学号查询学生信息
	public Student queryStudentByNo(int studentNo){
		return null;
	}
	
	
	    /**
	    * @Title: queryAllStudent
	    * @Description: 查询所有的学生信息
	    * @param @return    参数
	    * @return List<Student>    返回类型
	    * @throws
	    */
	    
	public List<Student> queryAllStudent(){
		PreparedStatement pst=null;
		Connection connection=null;
		List<Student> listBack=new ArrayList<Student>();
		try {
		
		 connection = getConnection();
		 //condition中有哪些条件不确定
		String sql="select * from studentInfo where 1=1 ";
		
		//创建statement
		 pst = connection.prepareStatement(sql);

		//执行语句:如果是增删，改--》insert/update/delete语句。使用executeUpate();
		//一般不需要处理返回结果
		ResultSet rs = pst.executeQuery();
		//rs.next取resultSet的下一行数据，如果有数据返回true,没有返回false
		while(rs.next()) {
			int studentNo=rs.getInt(1);//根据字段所在的列获取数据
			String studentName=rs.getString(2);
			String grade=rs.getString(3);
			String school=rs.getString(4);
			
			Student student=new Student();
			student.setStudentNO(studentNo);
			student.setStudentName(studentName);
			student.setGrade(grade);
			student.setSchool(school);
			listBack.add(student);
			
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			//在finally里面释放资源
			try {
				pst.close();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listBack;
	}
	//通过条件查询学生信息
	public List<Student> queryStudentByCondition(StudentCondition condition){
		PreparedStatement pst=null;
		Connection connection=null;
		
		List<Student> listBack=new ArrayList<Student>();
		
		try {
		
		 connection = getConnection();
		 //condition中有哪些条件不确定
		String sql="select * from studentInfo where 1=1 ";
		//判断条件中是否有学号
		if(condition.getStudentNO()!=null) {
			sql=sql+ " and studentNo="+condition.getStudentNO();
		}
		//判断条件中是否有姓名
		if(condition.getStudentName()!=null && !"".equals(condition.getStudentName())) {
			sql=sql+" and studentname="+condition.getStudentName();
		}
		
		//创建statement
		 pst = connection.prepareStatement(sql);

		//执行语句:如果是增删，改--》insert/update/delete语句。使用executeUpate();
		//一般不需要处理返回结果
		ResultSet rs = pst.executeQuery();
		//rs.next取resultSet的下一行数据，如果有数据返回true,没有返回false
		while(rs.next()) {
			int studentNo=rs.getInt(1);//根据字段所在的列获取数据
			String studentName=rs.getString(2);
			String grade=rs.getString(3);
			String school=rs.getString(4);
			
			Student student=new Student();
			listBack.add(student);
			
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			//在finally里面释放资源
			try {
				pst.close();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listBack;
	}

}
