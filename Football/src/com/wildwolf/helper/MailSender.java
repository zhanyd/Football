package com.wildwolf.helper;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 员工管理邮件发送类
 * @author：欧健华 工号：itd043 分机号：3143
 */
public class MailSender {

	private static Properties props;
	private static  String fromAddress;
	private static String senderUserName;
	private static String senderPassword;
	private static String subject;
	private static String userNameContent;
	private static String passwordContent;
	
   static {	
			ResourceBundle rb = ResourceBundle.getBundle("mailOfEmployee",Locale.SIMPLIFIED_CHINESE);
			props = new Properties();
			Enumeration enumberation = rb.getKeys();
			while (enumberation.hasMoreElements()) {
				String key = (String) enumberation.nextElement();
				props.setProperty(key, rb.getString(key));
			}
			
			fromAddress = props.getProperty("mail.address.from").trim();
			senderUserName = props.getProperty("mail.sender.name").trim();
			senderPassword = props.getProperty("mail.sender.password").trim();
			
			subject = props.getProperty("mail.subject").trim();
			
	}

	public void send(MailMessage mailMessage) {
		try {
			Session sendMailSession;			
			PopupAuthenticator popA = new PopupAuthenticator();
			popA.performCheck(senderUserName,senderPassword); 
			sendMailSession = Session.getInstance(props, popA);
			Message newMessage = new MimeMessage(sendMailSession);
			newMessage.setFrom(new InternetAddress(fromAddress));
			newMessage.setRecipient(Message.RecipientType.TO,
					new InternetAddress(mailMessage.getToAddress()));
			newMessage.setSubject(subject);
			/********* send userName ***** send password ***********************/
			newMessage.setText(mailMessage.getContent());
			Transport.send(newMessage);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void send4RegenerateNewPassword(MailMessage mailMessage) {
		try {
			Session sendMailSession;			
			PopupAuthenticator popA = new PopupAuthenticator();
			popA.performCheck(senderUserName,senderPassword); 
			sendMailSession = Session.getInstance(props, popA);
			Message newMessage = new MimeMessage(sendMailSession);
			newMessage.setFrom(new InternetAddress(fromAddress));
			newMessage.setRecipient(Message.RecipientType.TO,
					new InternetAddress(mailMessage.getToAddress()));
			newMessage.setSubject(subject);
			
			/********* send password ***********************/
//			newMessage.setText(passwordContent + mailMessage.getPasswordContent());
			Transport.send(newMessage);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
	
	

	private static class PopupAuthenticator extends Authenticator {
		String username = null;

		String password = null;

		public PopupAuthenticator() {
		}

		public PasswordAuthentication performCheck(String user, String pass) {
			username = user;
			password = pass;
			return getPasswordAuthentication();
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}
	
	
	public class MailMessage {
		
		private String toAddress;
		private String subject;
		private String content;
		
		public MailMessage() {
			
		}
		

		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getToAddress() {
			return toAddress;
		}
		public void setToAddress(String toAddress) {
			this.toAddress = toAddress;
		}


		public String getContent() {
			return content;
		}


		public void setContent(String content) {
			this.content = content;
		}	
		
	}
}
