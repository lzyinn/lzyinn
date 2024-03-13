package PlagiarismChecker;

import java.util.HashSet;

public class SimHashUtils {
    public static long calSimHash(String text) {
        int bitLength = 64;
        HashSet<Long> hashSet = new HashSet<>();
        String[] tokens = text.split("\\s+");

        for (String token : tokens) {
            long tokenHash = MD5Utils.getMD5Hash(token); // 使用MD5生成token的哈希值
            long bitMask = 1L; // 用于逐位判断

            for (int i = 0; i < bitLength; i++) {
                if ((tokenHash & bitMask) != 0) {
                    hashSet.add((long) i);
                } else {
                    hashSet.remove((long) i);
                }
                bitMask <<= 1;
            }
        }
        
        // 返回合并后的哈希值
        long simHash = 0;
        for (long hash : hashSet) {
            simHash |= (1L << hash);
        }
        
        return simHash;
    }
}
