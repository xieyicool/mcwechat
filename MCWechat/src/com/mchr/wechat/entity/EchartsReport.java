package com.mchr.wechat.entity;

import java.util.ArrayList;

public class EchartsReport {

	public ArrayList<String> xvalue = new ArrayList<String>();
	public ArrayList<Double> yvalue = new ArrayList<Double>();
	public String remark;
	
	public EchartsReport(ArrayList<String> xvalue,ArrayList<Double> yvalue,String remark)
	{
		super();
		this.xvalue = xvalue;
		this.yvalue = yvalue;
		this.remark = remark;
	}
}
