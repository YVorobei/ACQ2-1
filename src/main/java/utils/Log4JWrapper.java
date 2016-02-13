package utils;

import org.apache.log4j.*;
import org.testng.Reporter;

import java.io.IOException;

/**
 * Created by ViTaLES on 13.02.2016.
 */
public class Log4JWrapper {

    private Log4JWrapper() {}

    private static final Logger LOGGER = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    // ****************** Default message content ********************
    private static final String INFO_LOG = "INFO: \"%s\"";
    private static final String ERROR_LOG = "ERROR: \"%s\" !";
    private static final String START_LOG = "START: *** \"%s\" ***";
    private static final String END_LOG = "END: *** \"%s\" ***";

    private static void layout() {
        Layout layout = new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN);
        Appender appenderConsole = new ConsoleAppender(layout);

        try {
            LOGGER.addAppender(new FileAppender(layout, "log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String error (String message) {
        LOGGER.error(String.format(ERROR_LOG, message));
        Reporter.log(String.format(ERROR_LOG, message));

        layout();

        return String.format(ERROR_LOG, message);
    }

    public static String info(String message) {
        LOGGER.info(String.format(INFO_LOG, message));
        Reporter.log(String.format(INFO_LOG, message));

        layout();

        return String.format(INFO_LOG, message);
    }

    public static String start(String message) {
        LOGGER.info(String.format(START_LOG, message));
        Reporter.log(String.format(START_LOG, message));

        layout();

        return String.format(START_LOG, message);
    }

    public static String end(String message) {
        LOGGER.info(String.format(END_LOG, message));
        Reporter.log(String.format(END_LOG, message));

        layout();

        return String.format(END_LOG, message);
    }

}
