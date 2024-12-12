package ru.netology.filemanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userinfo")
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    @Column
    private String USER_NAME;
    @Column
    private String PASSWORD;
    @Column
    private Boolean ACCOUNT_EXPIRED;
    @Column
    private Boolean ACCOUNT_LOCKED;
    @Column
    private Boolean CREDENTIALS_EXPIRED;
    @Column
    private Boolean ENABLED;

}
