package com.pojo;

import java.util.Date;

/**
    * @ClassName: StudentCondition
    * @Description: 封装学生信息查询条件
    * @author nieming
    * @date 2020年6月23日
    *
    */
    
public class StudentCondition extends Student {

	private Date startDate;
	private Date endDate;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
