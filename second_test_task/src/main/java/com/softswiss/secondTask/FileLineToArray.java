package com.softswiss.secondTask;

import com.softswiss.exceptions.EmptyFileException;
import com.softswiss.exceptions.FileNameException;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLineToArray {

    public int[] process(String path, String firstFileName, String secondFileName) {
        String firstStringWithWhitespaces = getStringFromFile(path, firstFileName);
        String secondStringWithWhitespaces = getStringFromFile(path, secondFileName);

        String firstString = removeWhitespacesFromString(firstStringWithWhitespaces);
        String secondString = removeWhitespacesFromString(secondStringWithWhitespaces);
        int[] firstArray = transformStringToIntArray(firstString);
        int[] secondArray = transformStringToIntArray(secondString);
        int[] finalArray = mergeArrays(firstArray, secondArray);

        return bubbleSortOfArray(finalArray);
    }

    private String getStringFromFile(String pathToFile, String fileName) {
        String unloadString;
        if (pathToFile.length() != 0 && fileName.length() != 0) {
            try {
                if (!Files.readAllLines(Paths.get(pathToFile, fileName)).isEmpty()) {
                    unloadString = Files.readAllLines(Paths.get(pathToFile, fileName)).get(0);
                } else {
                    throw new EmptyFileException();
                }

            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        } else {
            throw new FileNameException();
        }

        return unloadString;
    }

    private String removeWhitespacesFromString(String string) {
        return string.replaceAll("\\s+", "");
    }

    private int[] transformStringToIntArray(String string) {

        int[] array = new int[string.length()];
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] = Integer.parseInt(String.valueOf(string.charAt(i)));
            } catch (ClassCastException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return array;
    }

    private int[] mergeArrays(int[] firstArray, int[] secondArray) {
        int[] finalArrayWithNoUniqueElements = new int[firstArray.length + secondArray.length];

        System.arraycopy(firstArray, 0, finalArrayWithNoUniqueElements, 0, firstArray.length);
        System.arraycopy(secondArray, 0, finalArrayWithNoUniqueElements, firstArray.length, finalArrayWithNoUniqueElements.length - firstArray.length);

        int noUniqueElements = finalArrayWithNoUniqueElements.length;

        for (int i = 0; i < noUniqueElements; i++) {
            for (int m = i + 1; m < noUniqueElements; m++) {
                if (finalArrayWithNoUniqueElements[i] == finalArrayWithNoUniqueElements[m]) {
                    finalArrayWithNoUniqueElements[m] = finalArrayWithNoUniqueElements[noUniqueElements - 1];
                    noUniqueElements--;
                }
            }
        }

        int[] finalArray = new int[noUniqueElements];
        System.arraycopy(finalArrayWithNoUniqueElements, 0, finalArray, 0, noUniqueElements);

        return finalArray;
    }

    private int[] bubbleSortOfArray(int[] finalArray) {
        for (int i = 0; i < finalArray.length; i++) {
            for (int m = i + 1; m < finalArray.length; m++) {
                int currentElement = finalArray[i];

                if (currentElement > finalArray[m]) {
                    int nextElement = finalArray[m];
                    finalArray[i] = nextElement;
                    finalArray[m] = currentElement;
                }
            }
        }

        for (int element : finalArray) {
            System.out.print(element);
        }
        return finalArray;
    }
}
