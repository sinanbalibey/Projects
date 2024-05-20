package com.bitirme.bitirme.requests;

public class RefreshRequest {

    Long userId;
    String refreshToken;

    public RefreshRequest(){

   }

    public RefreshRequest(Long userId, String refreshToken) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "RefreshRequest{" +
                "userId=" + userId +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
