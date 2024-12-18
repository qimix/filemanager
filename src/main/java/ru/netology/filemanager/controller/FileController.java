package ru.netology.filemanager.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.filemanager.model.FileInfo;
import ru.netology.filemanager.service.FileService;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    @Qualifier(value = "fileServiceImpl")
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @CrossOrigin
    @PostMapping("/file")
    public ResponseEntity<FileInfo> upload(@RequestParam MultipartFile attachment) {
        try {
            return new ResponseEntity<>(fileService.upload(attachment), HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @GetMapping("/list")
    public List<FileInfo> filelist(@RequestParam("limit") int limit, @RequestHeader("AUTH_TOKEN_KEY") String token, HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new RuntimeException("-----------No JWT token found in request headers------------");
        }
        System.out.println("=====================================");
        System.out.println(token);
        System.out.println("=====================================");

        return fileService.filelist();
    }

}