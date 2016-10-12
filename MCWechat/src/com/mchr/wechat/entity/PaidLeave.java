package com.mchr.wechat.entity;

import java.sql.Timestamp;

public class PaidLeave {
	
	public int empId;
	public String item;
	public Timestamp startTime;
	public Timestamp endTime;
	public double days;
	public double usedDays;
	public double leftDays;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public double getDays() {
		return days;
	}
	public void setDays(double days) {
		this.days = days;
	}
	public double getUsedDays() {
		return usedDays;
	}
	public void setUsedDays(double usedDays) {
		this.usedDays = usedDays;
	}
	public double getLeftDays() {
		return leftDays;
	}
	public void setLeftDays(double leftDays) {
		this.leftDays = leftDays;
	}

	
}
