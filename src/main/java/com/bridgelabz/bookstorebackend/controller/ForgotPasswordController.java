package com.bridgelabz.bookstorebackend.controller;


import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.exception.UsernameNotFoundException;
import com.bridgelabz.bookstorebackend.implementation.UserDetailServiceImpl;
import com.bridgelabz.bookstorebackend.model.ApplicationUser;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/bookstore/resetPassword")
public class ForgotPasswordController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserDetailServiceImpl customerService;

    @PostMapping("/forgot_password")
    public ResponseEntity<ResponseDTO> processForgotPassword(@RequestHeader("email") String email) {
        String token = RandomString.make(30);

        try {
            System.out.println("token -- " + token);
            customerService.updateResetPasswordToken(token, email);
            String resetPasswordLink = "http://localhost:8080/bookstore/resetPassword/reset_password";
            sendEmail(email, resetPasswordLink);
            ResponseDTO responseDTO = new ResponseDTO("message", "We have sent a reset password link to your email. Please check.");
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        } catch (UsernameNotFoundException | UnsupportedEncodingException | MessagingException ex) {
           throw new UsernameNotFoundException(ex.getMessage());
        }
    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("contact@bookStore.com", "Bookstore Support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @PostMapping("/reset_password")
    public ResponseEntity<ResponseDTO> processResetPassword(@RequestHeader("token") String token, @RequestHeader("password") String password) {

        ApplicationUser customer = customerService.getByResetPasswordToken(token);
        ResponseDTO responseDTO = new ResponseDTO("title", "Reset your password");

        if (customer == null) {
            responseDTO = new ResponseDTO("message", "Invalid Token");
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        } else {
            customerService.updatePassword(customer, password);

            responseDTO = new ResponseDTO("message", "You have successfully changed your password.");
        }

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

