package ru.testproject.bookshelf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.BookDao;
import ru.testproject.bookshelf.model.Book;
import ru.testproject.bookshelf.model.Page;
import ru.testproject.bookshelf.service.BookUploadService;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

@Service
public class BookUploadServiceImpl implements BookUploadService {
    private final BookDao bookDao;

    @Autowired
    public BookUploadServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void createBookPage(String filePath) throws IOException {
        Book book = bookDao.findByFilePath(filePath);
        int border = 50;
        int pageNumber = 1;
        Set<Page> pages = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), Charset.forName("UTF-8")))) {
            String strLine = "";
            while (true) {
                StringBuilder pageContent = new StringBuilder();
                if (strLine == null) {
                    break;
                }
                for (int i = 1; i <= border; i++) {
                    strLine = reader.readLine();
                    if (strLine == null) {
                        break;
                    }
                    pageContent.append(strLine);
                    pageContent.append("\n");
                }
                pages.add(new Page(book, pageNumber++, pageContent.toString()));
            }
            book.setPage(pages);
            bookDao.save(book);
        }
    }
}

