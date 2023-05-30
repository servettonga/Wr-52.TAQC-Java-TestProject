package net.eventsexpress.app.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<String> randomUser() {
        List<String> user = new ArrayList<>();
        String email = "";
        String password = "";
        final String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
                "X", "Y", "Z" };
        final String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        final String[] symbols = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "-", "=", "~" };
        for (int i = 0; i < 5; i++) {
            email += (letters[(int) (Math.random() * letters.length)]
                    + numbers[(int) (Math.random() * numbers.length)]);
            password += (letters[(int) (Math.random() * letters.length)]
                    + numbers[(int) (Math.random() * numbers.length)]
                    + symbols[(int) (Math.random() * symbols.length)]);
        }
        user.add(email + "@gmail.com");
        user.add(password);
        return user;
    }
}
