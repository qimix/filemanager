package ru.netology.filemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.filemanager.model.User;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
