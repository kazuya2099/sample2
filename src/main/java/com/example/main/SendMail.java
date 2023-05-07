package com.example.main;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) {
		try {
			Properties property = new Properties();
			property.put("mail.smtp.host", "smtp.gmail.com");
			property.put("mail.smtp.auth", "true");
			property.put("mail.smtp.port", "587");
			property.put("mail.smtp.starttls.enable", "true");
			property.put("mail.smtp.ssl.protocols", "TLSv1.2");
			property.put("mail.transport.protocol.rfc822", "smtp");
			
			Session session = Session.getInstance(property, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("アカウント", "パスワード");
				}
			});
			
			MimeMessage mimeMessage = new MimeMessage(session);
			InternetAddress toAddress = new InternetAddress("宛先アドレス", "宛先アドレスの表示名称");
			mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
			InternetAddress fromAddress = new InternetAddress("差出人アドレス", "差出人アドレスの表示名称");
			mimeMessage.setFrom(fromAddress);
			mimeMessage.setSubject("テスト送信", "ISO-2022-JP");
			mimeMessage.setText("あいうえお", "ISO-2022-JP");
			Transport.send(mimeMessage);
		} catch (SendFailedException se) {
			Address[] invalidAddresses = se.getInvalidAddresses();
			for (Address adress : invalidAddresses) {
				if (adress != null) {
					System.out.println("フォーマットエラー : " + adress);
				}
			}
			Address[] unsentAddresses = se.getValidUnsentAddresses();
			for (Address adress : unsentAddresses) {
				if (adress != null) {
					System.out.println("送信失敗 : " + adress);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
