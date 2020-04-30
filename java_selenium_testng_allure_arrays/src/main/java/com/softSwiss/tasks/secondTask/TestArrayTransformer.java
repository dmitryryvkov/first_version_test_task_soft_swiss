package com.softSwiss.tasks.secondTask;

import org.testng.annotations.Test;

public class TestArrayTransformer {
    String path = "src/main/resources/";
    String firstFileName = "array1.txt";
    String secondFileName = "array2.txt";
    String emptyArray = "emptyArray.txt";
    String arrayWithLetters = "emptyArray.txt";

    @Test()
    public void testProcess(){
        ArrayTransformer arrayTransformer = new ArrayTransformer();
        arrayTransformer.process(path, firstFileName, secondFileName);

    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testEmptyFileName(){
        ArrayTransformer arrayTransformer = new ArrayTransformer();
        arrayTransformer.process(path, "", secondFileName);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testEmptyPathName(){
        ArrayTransformer arrayTransformer = new ArrayTransformer();
        arrayTransformer.process("", firstFileName, secondFileName);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testEmptyFile(){
        ArrayTransformer arrayTransformer = new ArrayTransformer();
        arrayTransformer.process(path, emptyArray, secondFileName);
    }
}
