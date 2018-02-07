package ru.testproject.bookshelf.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.testproject.bookshelf.service.DigestService;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DigestServiceImpl implements DigestService {
    private static final Logger log = LoggerFactory.getLogger(DigestServiceImpl.class);

    /**
     * Кодировка исходной строки
     */
    private final String sourceStringEncoding;

    /**
     * Алгоритм хэширования
     */
    private final String hashingAlgorithm;


    public DigestServiceImpl(String sourceStringEncoding, String hashingAlgorithm) {
        this.sourceStringEncoding = sourceStringEncoding;
        this.hashingAlgorithm = hashingAlgorithm;
    }

    @Override
    public String hash(String source) {
        try {
            MessageDigest encoder = MessageDigest.getInstance(hashingAlgorithm);
            byte[] digest = encoder.digest(source.getBytes(sourceStringEncoding));
            return new String(Base64.getEncoder().encode(digest));
        } catch (NoSuchAlgorithmException e) {
            log.error("Unsupported hashing algorithm:" + hashingAlgorithm, e);
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            log.error("Unsupported encoding:" + sourceStringEncoding, e);
            throw new RuntimeException(e);
        }
    }
}
