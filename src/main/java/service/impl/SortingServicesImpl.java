package service.impl;

import entity.SimpleArray;

import java.util.Arrays;

public class SortingServicesImpl implements service.SortingServices {
    public int[] BubbleSort(SimpleArray array) {
        int[] intArray = array.getArray();
        if(intArray.length < 2) {
            return intArray;
        }
        boolean wasSwap = true;
        while(wasSwap) {
            wasSwap = false;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    int before = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = before;
                    wasSwap = true;
                }
            }
        }
        return intArray;
    }

    public int[] SortStream(SimpleArray array) {
        int[] intArray = array.getArray();
        if(intArray.length < 2) {
            return intArray;
        }
        return Arrays.stream(intArray).sorted().toArray();
    }

    public int[] ShakerSort(SimpleArray array) {
        int[] intArray = array.getArray();
        if (intArray.length < 2) {
            return intArray;
        }
        int begin = 0;
        int end = intArray.length - 1;
        boolean wasSwap = true;
        while (wasSwap) {
            wasSwap = false;
            for (int i = 0; i < end; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    int before = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = before;
                    wasSwap = true;
                }
            }
            if(!wasSwap) {
                break;
            }
            begin++;
            end--;
            for (int i = end; i > begin; i--) {
                if (intArray[i] < intArray[i - 1]) {
                    int before = intArray[i];
                    intArray[i] = intArray[i - 1];
                    intArray[i - 1] = before;
                    wasSwap = true;
                }
            }
        }
        return intArray;
    }

    public int[] SelectionSort(SimpleArray array) {
        int[] intArray = array.getArray();
        if (intArray.length < 2) {
            return intArray;
        }
        for (int min = 0; min < intArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < intArray.length; j++) {
                if (intArray[j] < intArray[least]) {
                    least = j;
                }
            }
            if (least != min) {
                int tmp = intArray[min];
                intArray[min] = intArray[least];
                intArray[least] = tmp;
            }
        }
        return intArray;
    }
}
