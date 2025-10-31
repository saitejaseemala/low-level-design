package handlers;

import enums.LogLevel;

public class ErrorHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel logLevel) {
        return LogLevel.ERROR == logLevel;
    }
}
