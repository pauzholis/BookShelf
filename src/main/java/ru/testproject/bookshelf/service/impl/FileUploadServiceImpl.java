package ru.testproject.bookshelf.service.impl;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import ru.testproject.bookshelf.service.FileUploadService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FileUploadServiceImpl implements FileUploadService {


    private static String ROOT = "files/";

    @Override
    public String uploadFile(byte[] fileContent, String fileName) throws IOException {
        User user =(org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername();
        Path filesDirectory = Paths.get(ROOT, userName);
        if (!Files.exists(filesDirectory)) {
            Files.createDirectories(filesDirectory);
        }
        Path bookFile = Paths.get(filesDirectory.toString(), fileName);

        Files.write(bookFile, fileContent);
        return bookFile.toString();
    }
}

