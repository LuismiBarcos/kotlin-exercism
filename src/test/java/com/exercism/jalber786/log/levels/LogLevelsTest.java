package com.exercism.jalber786.log.levels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogLevelsTest {
    @Test
    public void error_message() {
        Assertions.assertEquals(LogLevels.message("[ERROR]: Stack overflow"),"Stack overflow");
    }

    @Test
    public void warning_message() {
        Assertions.assertEquals(LogLevels.message("[WARNING]: Disk almost full"),"Disk almost full");
    }

    @Test
    public void info_message() {
        Assertions.assertEquals(LogLevels.message("[INFO]: File moved"),"File moved");
    }

    @Test
    public void message_with_leading_and_trailing_white_space() {
        Assertions.assertEquals(LogLevels.message("[WARNING]:   \tTimezone not set  \r\n"),"Timezone not set");
    }

    @Test
    public void error_log_level() {
        Assertions.assertEquals(LogLevels.logLevel("[ERROR]: Disk full"),"error");
    }

    @Test
    public void warning_log_level() {
        Assertions.assertEquals(LogLevels.logLevel("[WARNING]: Unsafe password"),"warning");
    }

    @Test
    public void info_log_level() {
        Assertions.assertEquals(LogLevels.logLevel("[INFO]: Timezone changed"),"info");
    }

    @Test
    public void error_reformat() {
        Assertions.assertEquals(LogLevels.reformat("[ERROR]: Segmentation fault"),"Segmentation fault (error)");
    }

    @Test
    public void warning_reformat() {
        Assertions.assertEquals(LogLevels.reformat("[WARNING]: Decreased performance"),"Decreased performance (warning)");
    }

    @Test
    public void info_reformat() {
        Assertions.assertEquals(LogLevels.reformat("[INFO]: Disk defragmented"), "Disk defragmented (info)");
    }

    @Test
    public void reformat_with_leading_and_trailing_white_space() {
        Assertions.assertEquals(LogLevels.reformat("[ERROR]: \t Corrupt disk\t \t \r\n"), "Corrupt disk (error)");
    }

}
