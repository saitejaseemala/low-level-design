import enums.LogLevel;
import handlers.LogHandler;
import models.LogMessage;

import java.time.LocalDateTime;

public class Logger {

    private static final Logger INSTANCE = new Logger();

    private final LogHandler handlerChain;

    private Logger() {
        handlerChain = LogHandlerConfiguration.build();
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void setLogMessage(String message, LogLevel logLevel) {
        LogMessage log = new LogMessage(logLevel, message, LocalDateTime.now());
        handlerChain.handle(log);
    }

    public void debug(String logMessage) {
        setLogMessage(logMessage, LogLevel.DEBUG);
    }

    public void info(String logMessage) {
        setLogMessage(logMessage, LogLevel.INFO);
    }

    public void warn(String logMessage) {
        setLogMessage(logMessage, LogLevel.WARN);
    }

    public void error(String logMessage) {
        setLogMessage(logMessage, LogLevel.ERROR);
    }
}
