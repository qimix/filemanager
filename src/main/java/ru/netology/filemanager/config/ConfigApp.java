package ru.netology.filemanager.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.filemanager.dao.FileDAO;
import ru.netology.filemanager.repository.FileInfoRepository;
import ru.netology.filemanager.service.FileServiceImpl;
import ru.netology.filemanager.util.FileManager;

@Configuration
public class ConfigApp {

    @Bean
    @Qualifier("entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("filemanager");
    }

    @Bean
    @Qualifier("entityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

}
