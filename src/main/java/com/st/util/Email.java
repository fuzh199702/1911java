package com.st.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static void sendEmail(String title,String info,String[] add_arr) throws MessagingException, IOException {
		//设置服务器的属性
		Properties props=new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		//创建会话
		Session session=Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("fuzh199702@163.com","BWDHWTPEDLNNPSDE");
			}
		});
		//开启调试模式
		session.setDebug(true);
		//获得一个传输者对象
		Transport t=session.getTransport();
		//四个参数--邮箱服务--端口号--账号--登录密码
		t.connect("smtp.163.com", 25, "fuzh199702@163.com", "ning,123");
		//邮件内容
		//创建邮件对象
		Message message=new MimeMessage(session);
		//指明邮件的发件人
		message.setFrom(new InternetAddress("fuzh199702@163.com"));
		//指明邮件的收件人
		InternetAddress[] I_add_arr=new InternetAddress[add_arr.length];
		for(int i=0;i<I_add_arr.length;i++) {
			I_add_arr[i]=new InternetAddress(add_arr[i]);
		}
		message.setRecipients(Message.RecipientType.TO, I_add_arr);
		//邮件的标题
		message.setSubject(title);
		
		//邮件的文本内容
		message.setContent(info, "text/html;charset=UTF-8");
//		String text="";
//		URL url=new URL("https://www.csdn.net/");
//		InputStream is=url.openStream();
//		char[] c_arr=new char[1024];
//		int l=0;
//		Reader r=new InputStreamReader(is);
//		while((l=r.read(c_arr))>0) {
//			text+=new String(Arrays.copyOf(c_arr, l));
//		}
//
//		message.setContent(text, "text/html;charset=UTF-8");
		//发送邮件
		t.sendMessage(message, message.getAllRecipients());
		//关闭传输者流
		t.close();
	}
}
