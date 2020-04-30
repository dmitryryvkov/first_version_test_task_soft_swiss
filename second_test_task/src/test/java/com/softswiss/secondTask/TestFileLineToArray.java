package com.softswiss.secondTask;

import org.testng.annotations.Test;

public class TestFileLineToArray {
    private String path = "src/test/resources/";
    private String firstFileName = "array1.txt";
    private String secondFileName = "array2.txt";

    private FileLineToArray arrayTransformer = new FileLineToArray();

    @Test()
    public void testProcess() {
        arrayTransformer.process(path, firstFileName, secondFileName);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testEmptyFileName() {
        arrayTransformer.process(path, "", secondFileName);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testEmptyPathName() {
        arrayTransformer.process("", firstFileName, secondFileName);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testEmptyFile() {
        String emptyArray = "emptyArray.txt";
        arrayTransformer.process(path, emptyArray, secondFileName);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFileWithStringArguments() {
        String arrayWithLetters = "strings.txt";
        arrayTransformer.process(path, arrayWithLetters, secondFileName);
    }
}
