package requests_response;

import models.User;

public class SendEmailRequest {
    private User user;
    private String title;
    private String body;


    public User getToUser() {
        return user;
    }

    public void setToUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
