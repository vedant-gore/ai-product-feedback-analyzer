package com.vedant.feedback_service.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String name;
    private String email;

    public UserDto() { }

    public UserDto(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
