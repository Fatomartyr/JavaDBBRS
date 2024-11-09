package org.example.auxiliaryclasses;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static String hashPassword(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }
    public static boolean checkPassword(String rawPassword, String hashedPassword) {
         return BCrypt.checkpw(rawPassword, hashedPassword);
    }
}
