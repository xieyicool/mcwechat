package com.mchr.wechat.entity;

import java.util.ArrayList;
import java.util.List;

public class WXMenu {
	public int id;
	public int xid;
	public int type;
	public String title;
	public String url;
	public int order;
	public String remark;
	
	public List<WXSubMenu> subMenuList;
	
	public WXMenu()
	{
		subMenuList = new ArrayList<WXSubMenu>(); 
	}
	
}
