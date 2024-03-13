package PlagiarismChecker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static long getMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            
            // 将前8个字节转换为long类型
            long hash = 0;
            for (int i = 0; i < 8; i++) {
                hash |= ((long) (messageDigest[i] & 0xFF)) << (8 * i);
            }
            
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
