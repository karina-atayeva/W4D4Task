package com.ctco.w4d4taskatayeva;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringProcessorTest {
    StringProcessor stringProcessor = new StringProcessor();

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfStringIsEmpty() {
        stringProcessor.processString("");
    }

    @Test
    public void shouldReturnBasicStringIfNoBackslash() {
        String expected = "abcdef";
        String actual = stringProcessor.processString(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveTwoBackslashesAndNewLines() {
        String expected = "abcdef";
        String actual = stringProcessor.processString("ab\\\ncd\\\nef");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveOneBackSlashAndNewLine() {
        String expected = "abcdef";
        String actual = stringProcessor.processString("abc\\\ndef");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNewLineIsBeforeBackslash() {
        String expected = "abc\n\\def";
        String actual = stringProcessor.processString(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBeModifiedIfOnlyBackSlashIsFoundAndNewLineNotFound() {
        String expected = "abc\n\\def";
        String actual = stringProcessor.processString(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBeModifiedIfOnlyNewLineWithoutBackSlashAheadIsFound() {
        String expected = "abc\ndef";
        String actual = stringProcessor.processString(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldProcessFirstElementInString() {
        String expected = "abcdef";
        String actual = stringProcessor.processString("\\\nabcdef");
        assertEquals(expected, actual);

    }

    @Test
    public void shouldProcessLastElementInString() {
        String expected = "abcdef";
        String actual = stringProcessor.processString("abcdef\\\n");
        assertEquals(expected, actual);

    }

    @Test
    public void shouldRemoveIfIsTheOnlyElementInList() throws Exception {
        String expected = "";
        String actual = stringProcessor.processString("\\\n");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfOddNumberOfBackslashes() throws Exception {
        String expected = "";
        String actual = stringProcessor.processString("\\\\\n");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfEvenNumberOfBackslashes() throws Exception {
        String expected = "\\\\\\n";
        String actual = stringProcessor.processString(expected);
        assertEquals(expected, actual);
    }
}
