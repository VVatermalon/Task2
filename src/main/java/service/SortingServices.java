package service;

import entity.SimpleArray;

public interface SortingServices {
    int[] bubbleSort(SimpleArray array);
    int[] sortStream(SimpleArray array);
    int[] shakerSort(SimpleArray array);
    int[] selectionSort(SimpleArray array);
}
