package ru.netology.filemanager.service;

import org.springframework.web.multipart.MultipartFile;
import ru.netology.filemanager.model.FileInfo;

import java.io.IOException;

public interface FileService {
    FileInfo upload(MultipartFile resource) throws IOException;
}
