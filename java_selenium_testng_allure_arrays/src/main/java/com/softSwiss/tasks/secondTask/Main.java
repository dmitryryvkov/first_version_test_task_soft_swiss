package com.softSwiss.tasks.secondTask;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/";
        String firstFileName = "array1.txt";
        String secondFileName = "array2.txt";

        String firstStringWithWhitespaces = getStringFromFile(path, firstFileName);
        String secondStringWithWhitespaces = getStringFromFile(path, secondFileName);

        String firstString = removeWhitespacesFromString(firstStringWithWhitespaces);
        String secondString = removeWhitespacesFromString(secondStringWithWhitespaces);
        int[] firstArray = transformStringToIntArray(firstString);
        int[] secondArray = transformStringToIntArray(secondString);
        int[] finalArray = mergeArrays(firstArray, secondArray);
        int[] finalSortedArray = bubbleSortOfArray(finalArray);

        for (int element : finalSortedArray) {
            System.out.print(element + " ");
        }
    }

    private static String getStringFromFile(String pathToFile, String fileName) {

        String unloadString;
        try {
            unloadString = Files.readAllLines(Paths.get(pathToFile, fileName)).get(0);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return unloadString;
    }

    private static String removeWhitespacesFromString(String string) {
        return string.replaceAll("\\s+", "");
    }


    private static int[] transformStringToIntArray(String string) {

        int[] array = new int[string.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(String.valueOf(string.charAt(i)));
        }
        return array;
    }

    private static int[] mergeArrays(int[] firstArray, int[] secondArray) {
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

    private static int[] bubbleSortOfArray(int[] finalArray) {
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
        return finalArray;
    }
}
