package ru.netology.filemanager.dao;
import org.springframework.stereotype.Component;
import ru.netology.filemanager.model.FileInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.netology.filemanager.repository.FileInfoRepository;

@Component
public class FileDAO {
    @Autowired
    @Qualifier("fileInfoRepository")
    FileInfoRepository fileInfoRepository;

    public FileInfo create(FileInfo createdFile) {
        return fileInfoRepository.save(createdFile);
    }
}
