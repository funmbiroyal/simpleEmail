package services;

import requests_response.RegisterRequest;
import requests_response.RegisterResponse;
import requests_response.SendEmailRequest;

public interface MailServices {

    RegisterResponse register(RegisterRequest registerRequest);
    String sendEmail(SendEmailRequest emailRequest);
    int getTotalNumberOfRegisteredUsers();

    int sendEmailCount();

    void resetPassword(String username, String newPassword, String confirmNewPassword);
}
