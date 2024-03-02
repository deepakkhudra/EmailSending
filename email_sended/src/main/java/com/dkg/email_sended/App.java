package com.dkg.email_sended;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class App {
	public static void main( String[] args ){
		
        System.out.println( "Jay SRee Raam");
        String message="Hello Dear,This is message.";
        String subject="deepak Khudra";
        String to="dksiwan0@gmail.com";
        String from="dksgupta02@gmail.com";
        
        sendEmail(message,subject,to,from)
;    }
	
	//this
	private static void sendEmail(String message, String subject, String to, String from) {
		
		//host
		String host="smtp.gmail.com";
		
		
		//get the
		Properties properties = System.getProperties();
		System.out.println("PROPERTIEs"+properties);
		
		//setting improtant
		
		//host set
		properties.setProperty("mail.smtp.host",host);
		properties.setProperty("mail.smtp.port","465");
		properties.setProperty("mail.smtp.ssl.enable","true");
		properties.setProperty("mail.smtp.auth","true");
		
		//step 1
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dksgupta02@gmail.com","neju txeq ywkf whzi");
			}
			
			
		});
		
		session.setDebug(true);
		
		//step 2
	     MimeMessage m=new MimeMessage(session);
	     
	     try {
	     //from
	     m.setFrom(from);
	     
	     //recipient
	     m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	     
	     //subject
	     m.setSubject(subject);
	     
	     //message text
	     m.setText(message);
	     
	     //send
	     
	     //step 3
	     Transport.send(m);
	     
	     System.out.println("Sent successfully message");
	     

	     }catch (Exception e) {
	    	 e.printStackTrace();
	     }
	     
	     
		
		
		
		
	}
}
