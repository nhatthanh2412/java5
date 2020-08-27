package com.example.demoJ5springboot.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demoJ5springboot.entity.Records;


@Service
public class MailService {
	@Autowired 
	private JavaMailSender javaMailSender;
	
	public void sendEmail(Records re) {
		String a;
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(re.getStaffid().getEmail());
        if(re.getType()==1) {
        	a="Thanh tich";
        }else {
        	a="Ky luat";
        }
        msg.setSubject("Testing from Spring Boot"+a);
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
	
}
