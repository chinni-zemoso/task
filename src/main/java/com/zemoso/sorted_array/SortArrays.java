package com.zemoso.sorted_array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SortArrays {

    private static final Logger logger = LoggerFactory.getLogger(SortArrays.class);

    public static void main(String[] args) {
        int[] firstArray = {1, 4, 7, 119, 23};
        int[] secondArray = {2, 5, 7, 16, 51, 67};
        int[] resultantArray = getSortedArray(firstArray, secondArray);
        for (int value : resultantArray)
            logger.info(value + " ");
    }

    private static int[] getSortedArray(int[] a, int[] b) {
        int lenOfFirstArray = a.length;
        int lengthOfSecondArray = b.length;
        int[] resultantArray = new int[lenOfFirstArray + lengthOfSecondArray];
        int firstArrayIndex = 0, secondArrayIndex = 0, resultantIndex = 0;

        while (firstArrayIndex < lenOfFirstArray && secondArrayIndex < lengthOfSecondArray) {
            if (a[firstArrayIndex] < b[secondArrayIndex])
                resultantArray[resultantIndex++] = a[firstArrayIndex++];
            else
                resultantArray[resultantIndex++] = b[secondArrayIndex++];
        }
        while (firstArrayIndex < lenOfFirstArray)
            resultantArray[resultantIndex++] = a[firstArrayIndex++];
        while (secondArrayIndex < lengthOfSecondArray)
            resultantArray[resultantIndex++] = b[secondArrayIndex++];

        return resultantArray;
    }
}

