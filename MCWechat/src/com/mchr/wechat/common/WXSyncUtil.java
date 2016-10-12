package com.mchr.wechat.common;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.mchr.wechat.dao.EmployeeDao;
import com.mchr.wechat.dao.SyncWXDao;
import com.mchr.wechat.entity.Department;
import com.mchr.wechat.entity.Employee;
import com.mchr.wechat.entity.WXMenu;
import com.mchr.wechat.entity.WXSubMenu;
import com.mchr.wechat.entity.WXTicket;
import com.mchr.wechat.entity.WXUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WXSyncUtil {

	private static String corpId = "wx174e6b3635649ed2";
	private static String secret = "R8lT_9nn_gEk7OgOhhDOyqPQTsqKb5EdcRcx0CsfVLP4bWwOrSJrUkt9U29YVnUe";

	private static String getToken() throws Exception {

		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s", corpId,
				secret);
		String s = MCNet.Get(url);
		JSONObject json = JSONObject.fromObject(s);
		String token = json.getString("access_token");

		return token;

	}

	public static WXTicket getTicket() throws Exception
	{
		String token = getToken();

		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=%s",
				token);

		String result = MCNet.Get(url);
		JSONObject json = JSONObject.fromObject(result);
		if(json.getInt("errcode") == 0)
		{
			WXTicket item = new WXTicket();
			item.noncestr = UUID.randomUUID().toString();
			item.ticket = json.getString("ticket");
			item.timestamp = System.currentTimeMillis();
			
			return item;
		}
		
		return null;
		
		
	}

	public static void sendMsg(String userId, String content, int agentId) throws Exception {
		String token = getToken();
		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s", token);

		JSONObject req = new JSONObject();
		req.put("touser", userId);
		req.put("msgtype", "text");
		req.put("agentid", 2);

		JSONObject contentObj = new JSONObject();
		contentObj.put("content", content);

		req.put("text", contentObj);

		String result = MCNet.Post(url, req.toString());
		JSONObject json = JSONObject.fromObject(result);

	}

	public static String getRedirectUrl(String requestUrl) {

		String encodeUrl = URLEncoder.encode(requestUrl);
		String url = String.format(
				"https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect",
				corpId, encodeUrl);
		return url;
	}

	public static String getUserIDFromWX(String code) throws Exception {

		String token = getToken();

		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=%s&code=%s",
				token, code);

		String result = MCNet.Get(url);
		JSONObject json = JSONObject.fromObject(result);
		return json.getString("UserId");
	}

	public static void syncDepartment() throws Exception {
		Map<Integer, Department> depsFromWechat = getDepartmentListFromWechat(1);
		Map<Integer, Department> despFromDB = SyncWXDao.getOrgnizationList();
		for (Map.Entry<Integer, Department> entry : despFromDB.entrySet()) {
			Department item = entry.getValue();
			if (depsFromWechat.containsKey(entry.getKey())) {
				updateDepartment(item.name, item.xid, item.id, item.order);
			} else {
				createDepartment(item.name, item.xid, item.id, item.order);
			}
		}

		WXSyncUtil.syncAccount();

		for (Map.Entry<Integer, Department> entry : depsFromWechat.entrySet()) {
			Department item = entry.getValue();
			if (!despFromDB.containsKey(entry.getKey())) {
				deleteDepartmentRecursion(entry.getKey());
				deleteDepartment(entry.getKey());
			}
		}
	}

	private static void deleteDepartmentRecursion(int depId) throws Exception {
		Map<Integer, Department> deps = getDepartmentListFromWechat(depId);
		for (Map.Entry<Integer, Department> entry : deps.entrySet()) {
			if (depId != entry.getKey()) {
				deleteDepartmentRecursion(entry.getKey());
				deleteDepartment(entry.getKey());
			}
		}

	}

	public static void createDepartment(String name, int parentId, int id, int order) throws Exception {

		String token = getToken();
		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=%s", token);

		JSONObject params = new JSONObject();
		params.put("name", name);
		params.put("parentid", parentId);
		params.put("order", order);
		params.put("id", id);

		String result = MCNet.Post(url, params.toString());

		JSONObject json = JSONObject.fromObject(result);

	}

	public static void updateDepartment(String name, int parentId, int id, int order) throws Exception {
		String token = getToken();
		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=%s", token);

		JSONObject params = new JSONObject();
		params.put("name", name);
		params.put("parentid", parentId);
		params.put("order", order);
		params.put("id", id);

		String result = MCNet.Post(url, params.toString());

		JSONObject json = JSONObject.fromObject(result);
	}

	public static Map<Integer, Department> getDepartmentListFromWechat(int id) throws Exception {
		String token = getToken();

		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=%s&id=%d", token,
				id);
		String result = MCNet.Get(url);
		JSONObject json = JSONObject.fromObject(result);

		Map<Integer, Department> deps = new HashMap<Integer, Department>();
		if (json.getInt("errcode") == 0) {
			JSONArray arr = json.getJSONArray("department");
			for (int i = 0; i < arr.size(); ++i) {
				JSONObject e = (JSONObject) arr.get(i);
				Department item = new Department();
				item.id = e.getInt("id");
				deps.put(item.id, item);
			}
		}

		return deps;
	}

	public static void deleteDepartment(int id) throws Exception {
		String token = getToken();
		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=%s&id=%d", token,
				id);
		String result = MCNet.Get(url);
		JSONObject json = JSONObject.fromObject(result);

	}

	public static void createAccount(Employee employee) throws Exception {
		String token = getToken();
		String url = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=" + token;
		JSONObject params = new JSONObject();
		JSONArray attrArray = new JSONArray();
		JSONObject attr = new JSONObject();
		JSONObject attrs = new JSONObject();
		params.put("userid", employee.WXAccount);
		params.put("name", employee.name);
		//params.put("weixinid", employee.WXAccount);
		params.put("email", employee.email);
		params.put("mobile", employee.mobile);
		params.put("department", employee.depId);
		params.put("gender", employee.gender);
		params.put("position", employee.job);
		attr.put("name", "工号");
		attr.put("value", employee.empNo);
		attrArray.add(attr);
		attrs.put("attrs", attrArray);
		params.put("extattr", attrs);

		String result = MCNet.Post(url, params.toString());

		JSONObject json = JSONObject.fromObject(result);
	}

	
	public static void updateAccount(Employee employee) throws Exception {
		String token = getToken();
		String url = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=" + token;
		JSONArray attrArray = new JSONArray();
		JSONObject attr = new JSONObject();
		JSONObject attrs = new JSONObject();
		JSONObject params = new JSONObject();
		params.put("userid", employee.WXAccount);
		params.put("name", employee.name);
		//params.put("weixinid", employee.WXAccount);
		params.put("email", employee.email);
		params.put("mobile", employee.mobile);
		params.put("department", employee.depId);
		params.put("gender", employee.gender);
		params.put("position", employee.job);
		attr.put("name", "工号");
		attr.put("value", employee.empNo);
		attrArray.add(attr);
		attrs.put("attrs", attrArray);
		params.put("extattr", attrs);

		String result = MCNet.Post(url, params.toString());
		JSONObject json = JSONObject.fromObject(result);
	}

	public static void syncAccount() throws Exception {
		Map<String, WXUser> usersFromWX = getAccountList(1);
		Map<String, Employee> usersFromDB = EmployeeDao.getAllEmplyee();

		for (Map.Entry<String, Employee> enter : usersFromDB.entrySet()) {

			Employee item = enter.getValue();

			if (usersFromWX.containsKey(item.WXAccount)) {
				//updateAccount(item.name, item.WXAccount, item.depId);
				updateAccount(item);
			} else {
				//createAccount(item.name, item.WXAccount, item.depId);
				createAccount(item);
			}

		}

		for (Map.Entry<String, WXUser> enter : usersFromWX.entrySet()) {
			WXUser user = enter.getValue();

			try {
				if (!usersFromDB.containsKey(user.userid)) {
					deleteAccount(user.userid);
				}
			} catch (Exception e) {

			}

		}

	}

	public static Map<String, WXUser> getAccountList(int depId) throws Exception {
		String token = getToken();

		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token="
				+ "%s&department_id=%d&fetch_child=1&status=0", token, depId);

		String result = MCNet.Get(url);
		JSONObject json = JSONObject.fromObject(result);

		Map<String, WXUser> users = new HashMap<String, WXUser>();
		if (json.getInt("errcode") == 0) {
			JSONArray arr = json.getJSONArray("userlist");
			for (int i = 0; i < arr.size(); ++i) {
				JSONObject e = arr.getJSONObject(i);

				WXUser user = new WXUser();
				user.userid = e.getString("userid");
				user.name = e.getString("name");
				//user.weixinid = e.getString("weixinid");
				users.put(user.userid, user);
			}
		}

		return users;
	}

	public static void deleteAccount(String wxAccount) throws Exception {
		String token = getToken();
		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=%s&userid=%d", token,
				wxAccount);
		String result = MCNet.Get(url);
		JSONObject json = JSONObject.fromObject(result);
	}

	public static void createMenu(int agentId) throws Exception {
		String token = getToken();
		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=%s&agentid=%d", token,
				agentId);

		JSONArray buttons = new JSONArray();
		Map<Integer, WXMenu> map = SyncWXDao.getWXMenuList();
		for (Map.Entry<Integer, WXMenu> enter : map.entrySet()) {
			int order = enter.getKey();

			WXMenu menu = enter.getValue();

			JSONArray subButtonList = new JSONArray();
			for (WXSubMenu subMenu : menu.subMenuList) {

				JSONObject subButton = new JSONObject();
				subButton.put("type", "view");
				subButton.put("name", subMenu.title);
				subButton.put("url", subMenu.url);

				subButtonList.add(subButton);
			}

			JSONObject button = new JSONObject();
			button.put("name", menu.title);
			button.put("sub_button", subButtonList);

			buttons.add(button);
		}

		JSONObject req = new JSONObject();
		req.put("button", buttons);

		String result = MCNet.Post(url, req.toString());
		JSONObject json = JSONObject.fromObject(result);

	}

	public static void deleteMenu(int agentId) throws Exception {
		String token = getToken();
		String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/menu/delete?access_token=%s&agentid=%d", token,
				agentId);
		String result = MCNet.Get(url);
		JSONObject json = JSONObject.fromObject(result);
	}

}
