package com.exercism.jalber786.log.levels;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {
    public static String message(String logLine) {
        String messageWOLogLevel = logLine.replaceAll("^\\[[A-z]+]:", "");
        String messageOnlyText = messageWOLogLevel.trim();

        return messageOnlyText;
    }


    public static String logLevel(String logLine) {
        Pattern logLevelPattern = Pattern.compile("^\\[[A-z]+]:");
        Matcher patternMatcher = logLevelPattern.matcher(logLine);
        patternMatcher.find();
        String fullLogLevel = patternMatcher.group(0);

        String processedLogLevel = (fullLogLevel.substring(1, fullLogLevel.length() - 2)).toLowerCase();

        return processedLogLevel;
    }


    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }

}
