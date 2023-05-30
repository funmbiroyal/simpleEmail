package services;

import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests_response.RegisterRequest;
import requests_response.RegisterResponse;
import requests_response.ResetPasswordRequest;
import requests_response.SendEmailRequest;

import static org.junit.jupiter.api.Assertions.*;
class MailServiceImplTest {
    MailServices mailServices;
    RegisterRequest request;
    RegisterResponse response;
    RegisterRequest request2;
    RegisterResponse response2;

    User user = new User("Kim","kim@gmail.com");

    SendEmailRequest emailRequest;
    @BeforeEach
    void setUp() {
        mailServices = new MailServiceImpl(user);
        request = new RegisterRequest();
        response = new RegisterResponse();
        request2 = new RegisterRequest();
        response2 = new RegisterResponse();
        emailRequest = new SendEmailRequest();

    }

    @Test
    void register() {
        //first user
        request.setName("Grace");
        request.setEmailAddress("grace@gmail.com");
        response = mailServices.register(request);
        assertEquals("You have Successfully Registered!", response.getMessage());
        assertEquals("Grace", response.getUser().getName());
        assertEquals("grace@gmail.com", response.getUser().getEmailAddress());


       //second user
        request2.setName("Kim");
        request2.setEmailAddress("kim@gmail.com");
        response2= mailServices.register(request2);
        assertEquals("You have Successfully Registered!",response2.getMessage());
        assertEquals("Kim",response2.getUser().getName());
        assertEquals("kim@gmail.com",response2.getUser().getEmailAddress());


    }

    @Test
    void getTheNumberOfTheRegisteredUsersTest(){
        //first user
        request.setName("Grace");
        request.setEmailAddress("grace@gmail.com");
        response = mailServices.register(request);
        assertEquals("You have Successfully Registered!", response.getMessage());
        assertEquals("Grace", response.getUser().getName());
        assertEquals("grace@gmail.com", response.getUser().getEmailAddress());

        //second user
        request2.setName("Kim");
        request2.setEmailAddress("kim@gmail.com");
        response2= mailServices.register(request2);
        assertEquals("You have Successfully Registered!",response2.getMessage());
        assertEquals("Kim",response2.getUser().getName());
        assertEquals("kim@gmail.com",response2.getUser().getEmailAddress());

        assertEquals(2,mailServices.getTotalNumberOfRegisteredUsers());
    }

    @Test
    void sendEmail() {
        request.setName("Grace");
        request.setEmailAddress("grace@gmail.com");
        response = mailServices.register(request);
        assertEquals("You have Successfully Registered!", response.getMessage());
        assertEquals("Grace", response.getUser().getName());
        assertEquals("grace@gmail.com", response.getUser().getEmailAddress());


        request2.setName("Kim");
        request2.setEmailAddress("kim@gmail.com");
        response2= mailServices.register(request2);
        assertEquals("You have Successfully Registered!",response2.getMessage());
        assertEquals("Kim",response2.getUser().getName());
        assertEquals("kim@gmail.com",response2.getUser().getEmailAddress());


        //assertThatThereAreTwoRegisteredUsers
        assertEquals(2,mailServices.getTotalNumberOfRegisteredUsers());

        emailRequest.setToUser(user);
        emailRequest.setTitle("Congratulations on your User Registration!");
        emailRequest.setBody("Hello " +emailRequest.getToUser().getName() + " , We are thrilled to have you!" +
        "if you are seeing this mail, it means you have successfully registered on our platform");

        System.out.println(mailServices.sendEmail(emailRequest));

        assertEquals(user, emailRequest.getToUser());
        assertEquals("Congratulations on your User Registration!",emailRequest.getTitle());
        assertEquals("Hello " +emailRequest.getToUser().getName() + " , We are thrilled to have you!" +
        "if you are seeing this mail, it means you have successfully registered on our platform", emailRequest.getBody());
        assertEquals(1, mailServices.sendEmailCount());

    }

    @Test
    void confirmThatEmailDeliveredToTheReceiverUponSuccessfulRegistration(){
        request.setName("Grace");
        request.setEmailAddress("grace@gmail.com");
        response = mailServices.register(request);
        assertEquals("You have Successfully Registered!", response.getMessage());
        assertEquals("Grace", response.getUser().getName());
        assertEquals("grace@gmail.com", response.getUser().getEmailAddress());

        request2.setName("Kim");
        request2.setEmailAddress("kim@gmail.com");
        response2= mailServices.register(request2);
        assertEquals("You have Successfully Registered!",response2.getMessage());
        assertEquals("Kim",response2.getUser().getName());
        assertEquals("kim@gmail.com",response2.getUser().getEmailAddress());


        //assertThatThereAreTwoRegisteredUsers
        assertEquals(2,mailServices.getTotalNumberOfRegisteredUsers());

        emailRequest.setToUser(user);
        emailRequest.setTitle("Congratulations on your User Registration!");
        emailRequest.setBody("Hello " +emailRequest.getToUser().getName() + " , We are thrilled to have you!" +
                "if you are seeing this mail, it means you have successfully registered on our platform");

        mailServices.sendEmail(emailRequest);

        assertEquals(user, emailRequest.getToUser());
        assertEquals("Congratulations on your User Registration!",emailRequest.getTitle());
        assertEquals("Hello " +emailRequest.getToUser().getName() + " , We are thrilled to have you!" +
                "if you are seeing this mail, it means you have successfully registered on our platform", emailRequest.getBody());
        assertEquals(1, mailServices.sendEmailCount());


    }
    @Test
    void testThatUserCanResetPassword(){
        ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
        request.setName("Grace");
        request.setEmailAddress("grace@gmail.com");
        response = mailServices.register(request);
        assertEquals("You have Successfully Registered!", response.getMessage());
        assertEquals("Grace", response.getUser().getName());
        assertEquals("grace@gmail.com", response.getUser().getEmailAddress());

        //resetPassword
        String name = "Gracey";
        String newPassword = "Test1234";
        String confirmNewPassword = "Test134";

        mailServices.resetPassword(name,newPassword,confirmNewPassword);
        assertEquals("Grace", request.getName());

    }


    @AfterEach
    void tearDown() {

    }
}