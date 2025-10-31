package handlers;

import enums.LogLevel;

public class InfoHandler extends LogHandler {

    @Override
    protected boolean canHandle(LogLevel logLevel) {
        return LogLevel.INFO == logLevel;
    }
}
