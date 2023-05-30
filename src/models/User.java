package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String emailAddress;

    private String [] listOfInbox = new String[50];
    private String [] listOfOutbox = new String[50];

    public String[] getListOfInbox() {
        return listOfInbox;
    }

    public void setListOfInbox(String[] listOfInbox) {
        this.listOfInbox = listOfInbox;
    }

    public String[] getListOfOutbox() {
        return listOfOutbox;
    }

    public void setListOfOutbox(String[] listOfOutbox) {
        this.listOfOutbox = listOfOutbox;
    }

    private String inbox;
    private String outbox;

    public String getInbox() {
        return inbox;
    }

    public void setInbox(String inbox) {
        this.inbox = inbox;
    }

    public String getOutbox() {
        return outbox;
    }

    public void setOutbox(String outbox) {
        this.outbox = outbox;
    }
    private Mailbox [] mailboxes= new Mailbox[2];
    private String title;


    public void setMailboxes(Mailbox[] mailboxes) {
        this.mailboxes = mailboxes;
    }

    private String body;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString(){
     return String.format("%s%n"
             + getName(),
             getEmailAddress())
             ;
    }
}

