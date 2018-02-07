package ru.testproject.bookshelf.service.impl;

import org.junit.Assert;
import org.junit.Test;
import ru.testproject.bookshelf.service.DigestService;

public class DigestServiceTest {
    private static final String SOURCE = "12345";
    private static final String EXPECTED_HASH = "WZRHGrsBESr8wYFZ9sx0tPURuZgG2lmzyvWpwXPKz8U=";
    private static final String SOURCE_ENCODING = "UTF-8";
    private static final String HASHING_ALGORITHM = "SHA-256";

    /**
     * Проверяем, что разные экземпляры сервиса хэша
     * при одинаковых параметрах генерируют одинаковый хэш
     */
    @Test
    public void hashTest() {
        DigestService digestService1 = new DigestServiceImpl(SOURCE_ENCODING, HASHING_ALGORITHM);
        String hash1 = digestService1.hash(SOURCE);

        DigestService digestService2 = new DigestServiceImpl(SOURCE_ENCODING, HASHING_ALGORITHM);
        String hash2 = digestService2.hash(SOURCE);

        Assert.assertNotEquals(digestService1, digestService2);
        Assert.assertEquals(EXPECTED_HASH, hash1);
        Assert.assertEquals(EXPECTED_HASH, hash2);
    }
}
