package com.bitirme.bitirme.responses;

import com.bitirme.bitirme.entities.Comment;

public class CommentResponse {

    Long id;

    Long userId;

    String userName;

    String text;

    public CommentResponse(){

    }

    public CommentResponse(Comment entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.text = entity.getText();
    }

    public CommentResponse(Long id, Long userId, String userName, String text) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CommentResponse{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
