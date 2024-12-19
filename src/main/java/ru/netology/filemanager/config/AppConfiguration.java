package ru.netology.filemanager.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

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
