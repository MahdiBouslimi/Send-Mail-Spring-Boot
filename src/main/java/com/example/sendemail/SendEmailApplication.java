package com.example.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SendEmailApplication {

    @Autowired
    private EmailSenderService service;
    public static void main(String[] args) {
        SpringApplication.run(SendEmailApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        /*service.SendSimpleEmail("mbouslimi07@gmail.com",
                "This is Email Body...",
                "This is email Subject");*/
        service.SendEmailWithAttachment("mbouslimi07@gmail.com",
                "This is Email Body...",
                "This email has attachment",
                "/home/asus/Images/mahdi.jpg");

    }
}
