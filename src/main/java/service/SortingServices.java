package service;

import entity.SimpleArray;

public interface SortingServices {
    int[] BubbleSort(SimpleArray array);
    int[] SortStream(SimpleArray array);
    int[] ShakerSort(SimpleArray array);
    int[] SelectionSort(SimpleArray array);
}
