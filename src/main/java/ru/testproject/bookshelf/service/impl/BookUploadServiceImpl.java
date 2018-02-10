package ru.testproject.bookshelf.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class BookUploadServiceImpl implements BookUploadService {
    private static final Logger logger = getLogger(BookUploadServiceImpl.class);
    private final BookDao bookDao;

    @Autowired
    public BookUploadServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void createBookPage(String filePath) {
        int boarder = 6;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath), Charset.forName("UTF-8")));
            String strLine;
            for (int i = 1; i <= boarder; i++) {
                strLine = reader.readLine();
                if (strLine != null) {
                    Book book = bookDao.findByFilePath(filePath);
                    Set<Page> pages = book.getPage();
                    pages.add(new Page(book, i, strLine));
                    bookDao.save(book);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            logger.info("something is wrong with the file path " + filePath);
        }
    }
}

