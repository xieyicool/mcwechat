package com.mchr.wechat.entity;

import java.sql.Date;

public class Attendance {
	
	public int id;
	public int empId;
	public Date countDate;
	public String status;
	public String checkinStatus;
	public double attendantHours;
	public double absentHours;
	public double leaveHours;
	public double overtimeHours;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getCountDate() {
		return countDate;
	}
	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCheckinStatus() {
		return checkinStatus;
	}
	public void setCheckinStatus(String checkinStatus) {
		this.checkinStatus = checkinStatus;
	}
	public double getAttendantHours() {
		return attendantHours;
	}
	public void setAttendantHours(double attendantHours) {
		this.attendantHours = attendantHours;
	}
	public double getAbsentHours() {
		return absentHours;
	}
	public void setAbsentHours(double absentHours) {
		this.absentHours = absentHours;
	}
	public double getLeaveHours() {
		return leaveHours;
	}
	public void setLeaveHours(double leaveHours) {
		this.leaveHours = leaveHours;
	}
	public double getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}


}
