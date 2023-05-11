package com.farm.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RSAUtilTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(RSAUtilTest.class);

    @Test
    void decryptBase64 () {
        String publicKey = RSAUtil.generateBase64PublicKey();
        LOGGER.info(publicKey);
    }

    @Test
    void generateBase64PublicKey () {
    }
}