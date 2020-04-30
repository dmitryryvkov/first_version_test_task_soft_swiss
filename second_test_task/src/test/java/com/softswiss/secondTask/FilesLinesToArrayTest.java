package com.softswiss.secondTask;

import com.softswiss.exceptions.EmptyFileException;
import com.softswiss.exceptions.FileNameException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilesLinesToArrayTest {
    private String path = "src/test/resources/";
    private String firstFileName = "array1.txt";
    private String secondFileName = "array2.txt";

    private FilesLinesToArray arrayTransformer = new FilesLinesToArray();

    @Test()
    public void testProcess() {
        Assert.assertEquals(arrayTransformer.process(path, firstFileName, secondFileName), new int[] {1,2,3,5,6,7});
    }

    @Test(expectedExceptions = FileNameException.class)
    public void testEmptyFileName() {
        arrayTransformer.process(path, "", secondFileName);
    }

    @Test(expectedExceptions = FileNameException.class)
    public void testEmptyPathName() {
        arrayTransformer.process("", firstFileName, secondFileName);
    }

    @Test(expectedExceptions = EmptyFileException.class)
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
