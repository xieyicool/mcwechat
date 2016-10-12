package com.mchr.wechat.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mchr.wechat.common.WXSyncUtil;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * Servlet implementation class WXCallbackServlet
 */
@WebServlet("/WXCallbackServlet")
public class WXCallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String sCorpID = "wx174e6b3635649ed2";
	private static final String sToken = "m4Mod9zaLPwhiJr";
	private static final String sEncodingAESKey = "rUCPD9jQKpw2hRSakKxJxrpEFI4wE08NrOcn7gWSGmQ";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WXCallbackServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String echostr = request.getParameter("echostr");
		if (echostr != null && echostr.length() > 0) {
			echo(request, response);
		} else {
			//replyMsg(request, response);
		}

	}

	private void replyMsg(HttpServletRequest request, HttpServletResponse response) {
		String msg_signature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");

		String encryptMsg = "";
		try {
			// 从request中取得输入流
			InputStream inputStream = request.getInputStream();
			// 读取输入流
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			// 得到xml根元素
			Element root = document.getRootElement();
			// 得到根元素的所有子节点
			List<Element> elementList = root.elements();
			// 遍历所有子节点
			for (Element e : elementList)
			{
				if(e.getName().equals("Encrypt"))
				{
					encryptMsg = e.getStringValue();
					break;
				}
			}
			inputStream.close();
				
		} catch (Exception ex) {

		}

		String content = "欢迎您来到MCHR企业微信号，您可以使用以下功能。您可以查询您的个人相关信息，阅读公司的新闻，以及进行业务流程的申请和审批。";

		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
			String msg = wxcpt.VerifyURL(msg_signature, timestamp, nonce, encryptMsg);
			
			StringReader sReader = new StringReader(msg);
			
			SAXReader reader = new SAXReader();
			Document document  = reader.read(sReader);
			// 得到xml根元素
			Element root = document.getRootElement();
			// 得到根元素的所有子节点
			List<Element> elementList = root.elements();
			// 遍历所有子节点
			
			Map<String, String> map = new HashMap<String,String>();
			for (Element e : elementList)
			{
				map.put(e.getName(), e.getStringValue());
			}
			
			WXSyncUtil.sendMsg((String)map.get("FromUserName"), content, Integer.parseInt((String)map.get("AgentID")));
			
		} catch (AesException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) { // 验证URL失败，错误原因请查看异常
			e.printStackTrace();
		}
	}

	private void echo(HttpServletRequest request, HttpServletResponse response) {
		String msg_signature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
			String sEchoStr = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
			System.out.println("verifyurl echostr: " + sEchoStr);
			// 验证URL成功，将sEchoStr返回
			// HttpUtils.SetResponse(sEchoStr);\

			response.getWriter().println(sEchoStr);
			response.getWriter().close();
		} catch (AesException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) { // 验证URL失败，错误原因请查看异常
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
