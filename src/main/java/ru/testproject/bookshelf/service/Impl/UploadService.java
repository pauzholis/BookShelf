package ru.testproject.bookshelf.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadService {
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://temp//";
    // Get the file and save it somewhere
    public void saveFile(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);
    }

}
