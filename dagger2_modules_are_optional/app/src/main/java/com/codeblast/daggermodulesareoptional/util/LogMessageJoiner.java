package com.codeblast.daggermodulesareoptional.util;

import java.util.ArrayDeque;
import java.util.Queue;

public class LogMessageJoiner {

    private static final int MAX_LINES = 8;

    private Queue<String> mLogMessages;

    public LogMessageJoiner() {
        mLogMessages = new ArrayDeque<>();
    }

    public String getLogText(String message) {
        if (mLogMessages.size() >= MAX_LINES) {
            mLogMessages.remove();
        }
        mLogMessages.add(message);
        return joinMessages();
    }

    private String joinMessages() {
        final StringBuilder sb = new StringBuilder();
        for (final String s : mLogMessages) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
