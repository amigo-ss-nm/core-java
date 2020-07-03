package com.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.dao.StudentDao;
import com.pojo.Student;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
    * @ClassName: ExcelTest
    * @Description: Excel的操作类
    * @author nieming
    * @date 2020年6月24日
    *
    */
    
public class ExcelTest {

	private StudentDao studentDao=new StudentDao();
	
	    /**
	    * @Title: importExcel
	    * @Description: 导入Excel数据
	    * @param     参数
	    * @return void    返回类型
	    * @throws
	    */
	    
	@Test
	public void importExcel() {
		Workbook workbook=null;
		Sheet sheet=null;
		try {
		//Excel文件
		File file = new File("E://教学//学校授课//吉首大学//实训//java程序设计//studenInfo.xls");
		//创建workbook
		workbook = Workbook.getWorkbook(file);
		//获取sheet页
		sheet = workbook.getSheet(0);
		//遍历sheet，读取一条一条数据，存储在pojo对象中
		//获取sheet页里面的数据行
		int rows = sheet.getRows();
		//初始化student对象
		//在for循环/while 循环不要初始化对象。
		Student student=new Student();
		for(int i=1;i<rows;i++) {
			//直接获取单元格
			Cell studentNoCell = sheet.getCell(0, i);//获取第一列
			Cell studentNameCell = sheet.getCell(1, i);//获取第一列
			Cell gradeCell = sheet.getCell(2, i);//获取第一列
			Cell schoolCell = sheet.getCell(3, i);//获取第一列
			
			//获取单元格里面的内容
			String studentNostr=studentNoCell.getContents();
			String studentNamestr=studentNameCell.getContents();
			String gradestr=gradeCell.getContents();
			String schoolstr=schoolCell.getContents();
			//将字符串类型学号转换为数字类型
			int studentNo=Integer.valueOf(studentNostr);
			
			//存入数据库
			student.setStudentNO(studentNo);
			student.setStudentName(studentNamestr);
			student.setGrade(gradestr);
			student.setSchool(schoolstr);
			
			studentDao.insertStudent(student);
		}
		
		//将读取到的数据存入数据库
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			workbook.close();
		}
	}
	@Test
	public void exportExcel() {
		WritableWorkbook workBook=null;
		try {
		//导出的文件
		File file = new File("E://教学//学校授课//吉首大学//实训//java程序设计//studenInfo_export.xls");
		//创建WritableWorkbook
		 workBook = Workbook.createWorkbook(file);
		//创建sheet
		WritableSheet sheet = workBook.createSheet("学生信息", 0);//创建一个学生信息的sheet页
		
		//构造excel头信息
		/*参数1：表示该Label在excel中x坐标
		参数2：表示该Label在excel中y坐标
		参数3：表示该label的内容*/
		Label studentNoHeader = new Label(0,0,"学号");
		Label studentNameHeader = new Label(1,0,"姓名");
		Label gradeHeader = new Label(2,0,"班级");
		Label schoolHeader = new Label(3,0,"学校");
		
		sheet.addCell(studentNoHeader);
		sheet.addCell(studentNameHeader);
		sheet.addCell(gradeHeader);
		sheet.addCell(schoolHeader);
		//查询数据库表数据
		List<Student> studentList = studentDao.queryAllStudent();
		int rowNumber=1;
		for (Student student : studentList) {
			Label studentNO = new Label(0,rowNumber,student.getStudentNO().toString());
			Label studentName = new Label(1,rowNumber,student.getStudentName());
			Label grade = new Label(2,rowNumber,student.getGrade());
			Label school = new Label(3,rowNumber,student.getSchool());
			
			sheet.addCell(studentNO);
			sheet.addCell(studentName);
			sheet.addCell(grade);
			sheet.addCell(school);
			rowNumber++;
		}
		
		//写入数据
		workBook.write();
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				workBook.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
