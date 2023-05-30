package services;

import models.Inbox;
import models.Mailbox;
import models.User;
import requests_response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MailServiceImpl implements MailServices {
    private final static int length = 50;
    private final RegisterResponse response = new RegisterResponse();
    private final MailBoxRequest mailBoxRequest= new MailBoxRequest();
    private final Mailbox mailbox = new Mailbox();
    private final Inbox [] inbox = new Inbox[length];

    private final ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
      private final User user;
    private final List<Object> registeredUsers = new ArrayList<>();

    public MailServiceImpl(User user) {
        this.user = user;
    }

    public RegisterResponse register(RegisterRequest request) {

        user.setName(request.getName());
        user.setEmailAddress(request.getEmailAddress());
        response.setMessage("You have Successfully Registered!");
        response.setUser(user);
        registeredUsers.add(user);
        return response;

    }
    public String sendEmail(SendEmailRequest emailRequest){

        if (registeredUsers.contains(emailRequest.getToUser())){
          user.setTitle(emailRequest.getTitle());
          user.setBody(emailRequest.getBody());
        }
//        emailRequest.getToUser().setInbox(mailBoxRequest.getInbox());
//
//        var listOfInbox = emailRequest.getToUser().getListOfInbox();
//          var foundInbox = emailRequest.getToUser().getInbox();
//
//          for(int i = 0; i<= inbox.length; i++){
//              listOfInbox[i] = foundInbox;
//          }
        System.out.println(user.getTitle());
        System.out.println(user.getBody());

        return "Mail has been sent to " + user.getEmailAddress();
    }

    public int getTotalNumberOfRegisteredUsers() {
        return registeredUsers.size();
    }


    public int sendEmailCount() {
        int times = 0;
        return ++times;
    }

    @Override
    public void resetPassword(String username, String newPassword, String confirmNewPassword) {

        //todo refactor ,the user should have password as attribute and  ability to be able to reset password
        if (user.getName().equals(username)){
            System.out.println("user exist, you can reset your password");
        }else {
            System.out.println("user does not exist!!!");
        }
        if(newPassword.equals(confirmNewPassword)){
            System.out.println("Password reset was successful");
        }else {
            System.out.println("Password does not match");
        }

    }


}
