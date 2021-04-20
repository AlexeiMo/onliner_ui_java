package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class CustomLogger {

    private static final Logger log = LogManager.getLogger(CustomLogger.class);

    public static void info (final String message) {
        log.info(message);
    }

    public static void warn (final String message) {
        log.warn(message);
    }

    public static void error (final String message) {
        log.error(message);
    }

    public static void fatal (final String message) {
        log.fatal(message);
    }

    public static void debug (final String message) {
        log.debug(message);
    }

}
