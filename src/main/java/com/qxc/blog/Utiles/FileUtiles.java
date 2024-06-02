package com.qxc.blog.Utiles;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午3:28
 * @Version 1.0
 * @PACKAGE com.qxc.blog.Utiles
 */
public class FileUtiles {

    /**
     * 计算SHA256哈希值
     *
     * @param filePath 文件路径
     * @return 字节数组
     * @throws IOException              IO异常
     * @throws NoSuchAlgorithmException NoSearch算法异常
     */
    public static byte[] calculateSHA256(FileInputStream fis) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (
                FileChannel channel = fis.getChannel();
                DigestInputStream dis = new DigestInputStream(fis, digest)) {
            ByteBuffer buffer = ByteBuffer.allocate(8192); // 8 KB buffer
            while (channel.read(buffer) != -1) {
                buffer.flip();
                digest.update(buffer);
                buffer.clear();
            }
            return digest.digest();
        }
    }

    /**
     * 将字节数组转换为String类型哈希值
     *
     * @param bytes 字节数组
     * @return 哈希值
     */
    public static @NotNull String bytesToHex(byte @NotNull [] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
