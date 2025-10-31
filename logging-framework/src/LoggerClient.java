import enums.LogLevel;
import appenders.ConsoleAppender;
import appenders.FileAppender;
import formatters.JsonFormatter;
import formatters.TextFormatter;

public class LoggerClient {
    public static void main(String[] args) {
        Logger log = Logger.getInstance();

        LogHandlerConfiguration.addAppenderForLevel(LogLevel.DEBUG, new ConsoleAppender(new TextFormatter()));
        LogHandlerConfiguration.addAppenderForLevel(LogLevel.INFO, new ConsoleAppender(new TextFormatter()));
        LogHandlerConfiguration.addAppenderForLevel(LogLevel.WARN, new ConsoleAppender(new TextFormatter()));
        LogHandlerConfiguration.addAppenderForLevel(LogLevel.WARN, new FileAppender(new TextFormatter(), "warning-logs.txt"));
        LogHandlerConfiguration.addAppenderForLevel(LogLevel.ERROR, new ConsoleAppender(new TextFormatter()));
        LogHandlerConfiguration.addAppenderForLevel(LogLevel.ERROR, new FileAppender(new JsonFormatter(), "logs.txt"));

        log.debug("Running state machine");
        log.info("Entered into the main loop");
        log.warn("Oops!! warning");
        log.error("Error!! Timed out");
    }
}