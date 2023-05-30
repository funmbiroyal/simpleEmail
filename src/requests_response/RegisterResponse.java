package requests_response;

import models.User;

public class RegisterResponse {
    private String message;
    private User user;

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMessage(String s) {
        message = s;
    }
}
