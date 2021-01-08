package com.iut.assistance.production.services;

import com.iut.assistance.production.commons.exceptions.ApiRequestException;
import com.iut.assistance.production.models.entities.User;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender sender;

    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmailConfirmation(User user) {
        try {
            MimeMessage mimeMessage = sender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("Email verification");
            messageHelper.setText(user.getValidationUser().getEmailConfirmationToken(), true);
            sender.send(mimeMessage);
        } catch (MessagingException exception) {
            throw new ApiRequestException(exception.getMessage());
        }

    }

}
