package utils;

import java.time.LocalDateTime;

public class LoggerUtil {
    public static void logInfo(String message) {
        System.out.println(LocalDateTime.now() + " INFO: " + message);
    }

    public static void logWarning(String message) {
        System.out.println(LocalDateTime.now() + " WARNING: " + message);
    }

    public static void logSevere(String message) {
        System.out.println(LocalDateTime.now() + " SEVERE: " + message);
    }
}
