package com.st;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mode1 {

	public static void main(String[] args) throws MessagingException, IOException {
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
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress("fuzh199702@163.com"));
		message.setRecipients(Message.RecipientType.TO, new InternetAddress[] {new InternetAddress("fuzh199702@163.com")});
		message.setSubject("-----标题------------");
		String text="";
		URL url=new URL("http://localhost:8080/emailfile2");
		InputStream is=url.openStream();
		char[] c_arr=new char[1024];
		int l=0;
		Reader r=new InputStreamReader(is);
		while((l=r.read(c_arr))>0) {
			text+=new String(c_arr);
		}
//		message.setContent("------hello ,张维浩-----------------", "text/html;charset=UTF-8");
		message.setContent(text, "text/html;charset=UTF-8");
		//发送邮件
		t.sendMessage(message, message.getAllRecipients());
		//关闭传输者流
		t.close();
	}
}
