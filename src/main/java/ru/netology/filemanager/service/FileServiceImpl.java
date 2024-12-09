package ru.netology.filemanager.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.filemanager.dao.FileDAO;
import ru.netology.filemanager.model.FileInfo;
import ru.netology.filemanager.util.FileManager;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    @Qualifier(value = "fileDAO")
    private final FileDAO fileDAO;

    @Autowired
    @Qualifier(value = "fileManager")
    private final FileManager fileManager;

    public FileServiceImpl(FileDAO fileDAO, FileManager fileManager) {
        this.fileDAO = fileDAO;
        this.fileManager = fileManager;
    }

    @Transactional(rollbackOn = {IOException.class})
    @Override
    public FileInfo upload(MultipartFile resource) throws IOException {
        String key = generateKey(resource.getName());
        FileInfo createdFile = FileInfo.builder()
                .setName(resource.getOriginalFilename())
                .setKey(key)
                .setSize(resource.getSize())
                .build();
        createdFile = fileDAO.create(createdFile);
        //fileManager.upload(resource.getBytes(), key);
        return createdFile;
    }

    private String generateKey(String name) {
        return DigestUtils.md5Hex(name + LocalDateTime.now().toString());
    }

}