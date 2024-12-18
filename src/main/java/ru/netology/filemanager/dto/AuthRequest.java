package ru.netology.filemanager.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {
    private String login;
    private String password;

    public String getUsername() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
