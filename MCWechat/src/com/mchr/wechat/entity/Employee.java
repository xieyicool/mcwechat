package com.mchr.wechat.entity;

import java.sql.Date;

public class Employee {
	
	public int empId;
	public String empNo;
	public String name;
	public String englishName;
	public byte[] photo;
	public int depId;
	public String depNo;
	public String dep;
	public String job;
	public String officePhone;
	public String reporter;
	public Date onboardDate;
	public String workStatus;
	public Date contractEndDate;
	public Date probationEndDate;
	public String mobile;
	public String email;
	public String WXAccount;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String gender;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepNo() {
		return depNo;
	}
	public void setDepNo(String depNo) {
		this.depNo = depNo;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public Date getOnboardDate() {
		return onboardDate;
	}
	public void setOnboardDate(Date onboardDate) {
		this.onboardDate = onboardDate;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public Date getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public Date getProbationEndDate() {
		return probationEndDate;
	}
	public void setProbationEndDate(Date probationEndDate) {
		this.probationEndDate = probationEndDate;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWXAccount() {
		return WXAccount;
	}
	public void setWXAccount(String wXAccount) {
		WXAccount = wXAccount;
	}
	
	
	
	
	

}
