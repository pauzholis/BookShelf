package ru.testproject.bookshelf.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.testproject.bookshelf.service.FileUploadService;
import static org.slf4j.LoggerFactory.getLogger;
import java.io.IOException;

@Controller
public class UploadController {
private static final Logger logger = getLogger(UploadController.class);
    private final FileUploadService fileUploadService;

    @Autowired
    public UploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    /**
     * Страница загрузки файла книги
     */
    @GetMapping("/loadBook")
    public String showUploadBookPage() {
        return "upload";
    }

    /**
     * Загрузка файла
     */
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes ) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath;
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            filePath = fileUploadService.uploadFile(file.getBytes(),file.getOriginalFilename());
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            logger.error("An error occurred", e);
        }

        return "redirect:/uploadStatus";
    }

    /**
     * Статус загрузки книги
     */
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}





