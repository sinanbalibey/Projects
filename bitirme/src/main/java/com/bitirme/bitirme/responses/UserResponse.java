package com.bitirme.bitirme.responses;

import com.bitirme.bitirme.entities.User;

public class UserResponse {


    Long id;
    int avatarId;
    String userName;

    public UserResponse(){

    }

    public UserResponse(Long id, int avatarId, String userName) {
        this.id = id;
        this.avatarId = avatarId;
        this.userName = userName;
    }
    public UserResponse(User entity) {
        this.id = entity.getId();
        this.avatarId = entity.getAvatar();
        this.userName = entity.getUserName();
    }
}
