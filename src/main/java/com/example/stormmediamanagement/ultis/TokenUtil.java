package com.example.stormmediamanagement.ultis;

import java.security.MessageDigest;
import java.util.Base64;

public class TokenUtil {

    public static String generateToken(String secretKey, String username) {
        try {
            // Kết hợp secret key, user id và giá trị ngẫu nhiên (UUID)
            String data = secretKey + username ;

            // Tạo mã băm từ dữ liệu
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes("UTF-8"));

            // Mã hóa mã băm thành chuỗi Base64
            String token = Base64.getEncoder().encodeToString(hashBytes);

            // Lưu trữ token vào cơ sở dữ liệu
            // Lưu ý: Bạn cần xác định cấu trúc và phương thức lưu trữ token vào db

            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean verifyToken(String secretKey, String username, String token) {
        try {
            // Decode the token from Base64 to byte array
            byte[] decodedBytes = Base64.getDecoder().decode(token);

            // Get the original data used to generate the token
            String data = secretKey + username;

            // Generate the hash of the original data
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes("UTF-8"));

            // Compare the decoded token with the hash of the original data
            return MessageDigest.isEqual(decodedBytes, hashBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
