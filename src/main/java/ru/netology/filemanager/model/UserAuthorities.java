package ru.netology.filemanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userauthorities")
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthorities {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    @Column
    private int USER_ID;
    @Column
    private int AUTHORITY_ID;
}
