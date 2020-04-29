package com.softSwiss.tasks.secondTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {

    int[] uploadFilesAndGetArrayOfUniqueElements() {

        String firstString = null;
        String secondString = null;

        /* getting Strings from files */
        try {
            firstString = Files.readAllLines(Paths.get("src/main/resources/", "array1.txt")).get(0);
            secondString = Files.readAllLines(Paths.get("src/main/resources/", "array2.txt")).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* removing whitespaces */
        firstString = Objects.requireNonNull(firstString).replaceAll("\\s+", "");
        secondString = Objects.requireNonNull(secondString).replaceAll("\\s+", "");

        int[] firstArray = new int[Objects.requireNonNull(firstString).length()];
        int[] secondArray = new int[Objects.requireNonNull(secondString).length()];

        /* transforming Strings to arrays */
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(String.valueOf(firstString.charAt(i)));
        }

        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Integer.parseInt(String.valueOf(secondString.charAt(i)));
        }

        int[] finalArrayWithNoUniqueElements = new int[firstArray.length + secondArray.length];

        /* merging of 2 arrays */
        System.arraycopy(firstArray, 0, finalArrayWithNoUniqueElements, 0, firstArray.length);
        System.arraycopy(secondArray, 0, finalArrayWithNoUniqueElements, firstArray.length, finalArrayWithNoUniqueElements.length - firstArray.length);

        int noUniqueElements = finalArrayWithNoUniqueElements.length;

        /* removing repeat elements  */
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

        /* the bubble sorting of the final array*/
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
        /* printing an array values in the console */
        for (int element : finalArray) {
            System.out.print(element + " ");
        }

        return finalArray;
    }
}
