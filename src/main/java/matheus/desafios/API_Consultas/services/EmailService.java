package matheus.desafios.API_Consultas.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

@Autowired
private JavaMailSender emailSender;


public void sendEmail(String to,String subject,String text) {
SimpleMailMessage mail = new SimpleMailMessage();
mail.setTo(to);
mail.setSubject(subject);
mail.setText(text);
emailSender.send(mail);
}
}
