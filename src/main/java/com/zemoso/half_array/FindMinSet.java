package com.zemoso.half_array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMinSet {
    private static final Logger logger = LoggerFactory.getLogger(FindMinSet.class);

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        logger.info(String.valueOf(getMinArraySize(array)));
    }

    private static int getMinArraySize(int[] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //Frame, each integer occurance
        for (int index = 0; index < array.length; index++) {
            Integer currValue = map.get(array[index]);
            if (currValue == null)
                map.put(array[index], 1);
            else
                map.put(array[index], currValue + 1);
        }
        //Get, Only Occurances from Map
        int[] occurances = new int[map.size()];
        int occuranceIndex = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            occurances[occuranceIndex++] = entry.getValue();
        }
        //Sort the array
        Arrays.sort(occurances);
        //Iterate Array, From backwards to find  "minimum size of the set"
        int result = 0, size = array.length;
        for (int index = occurances.length - 1; index >= 0; index--) {
            if (size <= (array.length / 2))
                break;
            result++;
            size -= occurances[index];
        }
        return result;
    }
}
