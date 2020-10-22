package com.zemoso.sorted_array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortArrays {

    private static final Logger logger = LoggerFactory.getLogger(SortArrays.class);

    public static void main(String[] args) {
        int[] firstArray = {1, 4, 7, 19, 23};
        int[] secondArray = {2, 5, 7, 16, 51, 67};
        int[] resultantArray = getSortedArray(firstArray, secondArray);
        for (int value : resultantArray)
            logger.info(value + " ");
    }

    private static int[] getSortedArray(int[] a, int[] b) {
        int lengthOfFirstArray = a.length;
        int lengthOfSecondArray = b.length;
        if (lengthOfFirstArray == 0 && lengthOfSecondArray == 0) {
            throw new RuntimeException("Array is empty");
        }
        long totalLengthOfArrays = (long) lengthOfFirstArray + lengthOfSecondArray;
        if (totalLengthOfArrays > Integer.MAX_VALUE) {
            throw new RuntimeException("Length of Arrays Crossing the Max Size");
        }
        int[] resultantArray = new int[lengthOfFirstArray + lengthOfSecondArray];
        int firstArrayIndex = 0, secondArrayIndex = 0, resultantArrayIndex = 0;

        while (firstArrayIndex < lengthOfFirstArray && secondArrayIndex < lengthOfSecondArray) {
            if (a[firstArrayIndex] < b[secondArrayIndex]) {
                resultantArray[resultantArrayIndex++] = a[firstArrayIndex++];
            } else {
                resultantArray[resultantArrayIndex++] = b[secondArrayIndex++];
            }
        }
        while (firstArrayIndex < lengthOfFirstArray) {
            resultantArray[resultantArrayIndex++] = a[firstArrayIndex++];
        }
        while (secondArrayIndex < lengthOfSecondArray) {
            resultantArray[resultantArrayIndex++] = b[secondArrayIndex++];
        }
        return resultantArray;
    }
}

