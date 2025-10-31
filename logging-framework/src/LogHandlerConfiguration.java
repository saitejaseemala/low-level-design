import enums.LogLevel;
import handlers.*;
import appenders.LogAppender;

public class LogHandlerConfiguration {

    private static final LogHandler debugHandler = new DebugHandler();
    private static final LogHandler infoHandler = new InfoHandler();
    private static final LogHandler warningHandler = new WarnHandler();
    private static final LogHandler errorHandler = new ErrorHandler();

    public static LogHandler build() {
        debugHandler.setNext(infoHandler);
        infoHandler.setNext(warningHandler);
        warningHandler.setNext(errorHandler);

        return debugHandler;
    }

    public static void addAppenderForLevel(LogLevel logLevel, LogAppender logAppender) {
        switch (logLevel) {
            case DEBUG -> debugHandler.subscribe(logAppender);
            case INFO -> infoHandler.subscribe(logAppender);
            case WARN -> warningHandler.subscribe(logAppender);
            case ERROR -> errorHandler.subscribe(logAppender);
        }
    }
}
