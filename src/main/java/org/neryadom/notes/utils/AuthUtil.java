package org.neryadom.notes.utils;

import java.util.HashSet;
import java.util.List;

public class AuthUtil {

    static HashSet<String> users = new HashSet<>(List.of("user_zero", "user_one"));

    public static boolean canAuthenticate(String key) {
        return users.contains(key);
    }
}
