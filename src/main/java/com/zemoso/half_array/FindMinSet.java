package com.zemoso.half_array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMinSet {
    private static final Logger logger = LoggerFactory.getLogger(FindMinSet.class);

    public static void main(String[] args) {
        int[] array = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        logger.info(String.valueOf(getMinArraySize(array)));
    }

    private static int getMinArraySize(int[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Array is empty");
        }
        Map<Integer, Integer> mapOfElementAndOccurance = new HashMap<Integer, Integer>();
        for (int element : array) {
            Integer legacyValue = mapOfElementAndOccurance.get(element);
            if (legacyValue == null) {
                mapOfElementAndOccurance.put(element, 1);
            } else {
                mapOfElementAndOccurance.put(element, legacyValue + 1);
            }
        }
        //Get, Only Occurances from Map
        int[] occurances = new int[mapOfElementAndOccurance.size()];
        int occuranceIndex = 0;
        for (Map.Entry<Integer, Integer> entry : mapOfElementAndOccurance.entrySet()) {
            occurances[occuranceIndex++] = entry.getValue();
        }
        Arrays.sort(occurances);
        //Iterate Array, From backwards to find  "minimum size of the set"
        int resultantSetSize = 0, size = array.length;
        for (int index = occurances.length - 1; index >= 0; index--) {
            if (size <= (array.length / 2))
                break;
            resultantSetSize++;
            size -= occurances[index];
        }
        return resultantSetSize;
    }
}
