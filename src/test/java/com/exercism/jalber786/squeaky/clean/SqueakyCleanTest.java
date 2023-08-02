package com.exercism.jalber786.squeaky.clean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SqueakyCleanTest {

    @Test
    public void empty() {
        Assertions.assertTrue(SqueakyClean.clean("").isEmpty());
    }

    @Test
    public void single_letter() {
        Assertions.assertEquals("A", SqueakyClean.clean("A"));
    }

    @Test
    public void string() {
        Assertions.assertEquals("àḃç", SqueakyClean.clean("àḃç"));
    }

    @Test
    public void spaces() {
        Assertions.assertEquals("my___Id", SqueakyClean.clean("my   Id"));
    }

    @Test
    public void leading_and_trailing_spaces() {
        Assertions.assertEquals("_myId_", SqueakyClean.clean(" myId "));
    }

    @Test
    public void ctrl() {
        Assertions.assertEquals("myCTRLCTRLCTRLId", SqueakyClean.clean("my\0\r\u007FId"));
    }

    @Test
    public void string_with_no_letters() {
        Assertions.assertTrue(SqueakyClean.clean("\uD83D\uDE00\uD83D\uDE00\uD83D\uDE00").isEmpty());
    }

    @Test
    public void keep_only_letters() {
        Assertions.assertEquals("ab", SqueakyClean.clean("a1\uD83D\uDE002\uD83D\uDE003\uD83D\uDE00b"));
    }

    @Test
    public void kebab_to_camel_case() {
        Assertions.assertEquals("àḂç", SqueakyClean.clean("à-ḃç"));
    }

    @Test
    public void kebab_to_camel_case_no_letter() {
        Assertions.assertEquals("aC", SqueakyClean.clean("a-1C"));
    }

    @Test
    public void omit_lower_case_greek_letters() {
        Assertions.assertEquals("MyΟFinder", SqueakyClean.clean("MyΟβιεγτFinder"));
    }

    @Test
    public void combine_conversions() {
        Assertions.assertEquals("_AbcĐCTRL", SqueakyClean.clean("9 -abcĐ\uD83D\uDE00ω\0"));
    }
}
