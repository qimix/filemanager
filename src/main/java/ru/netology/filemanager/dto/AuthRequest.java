package ru.netology.filemanager.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {
    private String email;
    private String password;

    public String getUsername() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
