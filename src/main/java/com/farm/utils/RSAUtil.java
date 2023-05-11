package com.farm.utils;
/**
 * Created by Administrator on 2022/2/8 0008.
 */

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPublicKey;

public class RSAUtil {

    //密码加密
    private static final KeyPair keyPair = initKey();


    /**
     * 、
     * 初始化key
     *
     * @return 返回 KeyPair
     */
    private static KeyPair initKey () {
        try {
            Provider provider = new BouncyCastleProvider();
            Security.addProvider(provider);
            SecureRandom random = new SecureRandom();
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", provider);
            generator.initialize(1024, random);
            return generator.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @param byteArray 解密
     * @return 解密
     */
    private static byte[] decrypt (byte[] byteArray) {
        try {
            Provider provider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
            Security.addProvider(provider);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", provider);
            PrivateKey privateKey = keyPair.getPrivate();
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] plainText = cipher.doFinal(byteArray);
            return plainText;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decryptBase64 (String string) {
        return new String(decrypt(Base64.decodeBase64(string.getBytes())));
    }

    public static String generateBase64PublicKey () {
        PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        return new String(Base64.encodeBase64(publicKey.getEncoded()));
    }

}
