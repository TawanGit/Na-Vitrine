package com.tawangit.agregate.dtos;

public class EmailDto{

    private String email;
    private String subject;
    private String text;
    private String inviteLink;



    public String getEmail() {
        return email;
    }

    public void setEmail(String setEmail) {
        this.email = setEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInviteLink() {
        return inviteLink;
    }

    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }
}
