/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.utilities;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ADMIN
 */
public class SecurityPassword {

    public static final String SENTENCE = "FraseLargaConDiferentesLetrasNumerosYCaracteresEspeciales_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_NO_USAR_ESTA_FRASE!_";
    public static final String ALGORITHMS = "AES/ECB/PKCS5Padding";
    public static final String AES = "AES";
    public static final String SHA = "SHA";
    public static final String UTF8 = "UTF-8";

    public static byte[] encrypt(String password) throws Exception {
        final byte[] bytes = password.getBytes(UTF8);
        final Cipher aes = getCipher(true);
        final byte[] cifrado = aes.doFinal(bytes);
        return cifrado;
    }

    public static String decrypt(byte[] cifrado) throws Exception {
        final Cipher aes = getCipher(false);
        final byte[] bytes = aes.doFinal(cifrado);
        return new String(bytes, UTF8);
    }

    private static Cipher getCipher(boolean isCode) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance(SHA);
        digest.update(SENTENCE.getBytes(UTF8));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, AES);

        final Cipher aes = Cipher.getInstance(ALGORITHMS);
        if (isCode) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

        return aes;
    }

    public static void main(String[] arg) throws Exception {
        System.out.println(Arrays.toString(SecurityPassword.encrypt("8704")).replace(" ", ""));
        System.out.println(SecurityPassword.decrypt(new byte[]{31, 87, 52, -32, -40, 106, 14, -5, -48, 17, 62, -39, -72, -48, -58, 42}));
    }

}
