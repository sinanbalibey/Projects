package com.bitirme.bitirme.requests;

public class CommentUpdateRequest {

    String text;

    public CommentUpdateRequest(){

    }

    public CommentUpdateRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CommentUpdateRequest{" +
                "text='" + text + '\'' +
                '}';
    }
}
