package handlers;

import enums.LogLevel;

public class DebugHandler extends LogHandler {

    @Override
    protected boolean canHandle(LogLevel logLevel) {
        return LogLevel.DEBUG == logLevel;
    }
}
