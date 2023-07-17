/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualiser;


import java.util.ArrayList;

/**
 * This class stores all of the sorting algorithms used by the application. 
 * @author Mark Seon
 */
public class SortingAlgorithms {

    private ArrayList<int[]> mergeSortOutput;
    
    /**
     * Creates a new SortingAlgorithms object.
     */
    public SortingAlgorithms() {
        mergeSortOutput = new ArrayList<>();
    }
    
    /**
     * Sorts the input array using bubble sort.
     * 
     * @param intArray The numbers to be sorted
     * @param showBubbles Whether numbers "bubbling" to the top is included in the output
     * @return An ArrayList containing int arrays, with each int array representing a 'frame' in the sorting process.
     */
    public ArrayList<int[]> bubbleSort(int[] intArray, boolean showBubbles) {
        ArrayList<int[]> output = new ArrayList<>();
        // add copy of the initial array to the outut
        output.add(intArray.clone());
        int temp;
        boolean swapped;
        for (int i = 0; i < intArray.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < intArray.length - 1 - i; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    temp = intArray[j + 1];
                    intArray[j + 1] = intArray[j];
                    intArray[j] = temp;
                    swapped = true;
                    if(showBubbles) {
                        output.add(intArray.clone());
                    }
                }
            }
            if(!showBubbles) {
                output.add(intArray.clone());
            }
            if (!swapped) {
                break;
            }
        }

        return output;
    }
    
    /**
     * Sorts the input array using insertion sort.
     * @param intArray The numbers to be sorted
     * @return An ArrayList containing int arrays, with each int array representing a 'frame' in the sorting process.
     */
    public ArrayList<int[]> insertionSort(int[] intArray) {
        ArrayList<int[]> output = new ArrayList<>();
        // add copy of the initial array to the outut
        output.add(intArray.clone());

        for (int i = 1; i < intArray.length; i++) {
            int currentNumber = intArray[i];
            int j = i - 1;
            while (j >= 0 && intArray[j] > currentNumber) {
                intArray[j + 1] = intArray[j];
                j--;
            }
            intArray[j + 1] = currentNumber;
            output.add(intArray.clone());
        }

        return output;
    }
    
    /**
     * Sorts the input array using merge sort.
     * @param intArray The numbers to be sorted
     * @param leftIndex The index of the leftmost number to be sorted
     * @param rightIndex  The index of the rightmost number to be sorted
     */
    private void mergeSort(int[] intArray, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            mergeSort(intArray, leftIndex, midIndex);
            mergeSort(intArray, midIndex + 1, rightIndex);
            merge(intArray, leftIndex, midIndex, rightIndex);
            mergeSortOutput.add(intArray.clone());
        }
    }
    
    private void merge(int[] intArray, int leftIndex, int midIndex, int rightIndex) {
        int leftLength = (midIndex + 1) - leftIndex;
        int rightLength = rightIndex - midIndex;
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];
        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = intArray[leftIndex + i];
        }
        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = intArray[midIndex + 1 + i];
        }
        
        int i = 0, j = 0, k = leftIndex;
        while(i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                intArray[k] = leftArray[i];
                i++;
            } else {
                intArray[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < leftLength) {
            intArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            intArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    /**
     * Sorts the input using merge sort, and returns an ArrayList containing the state of the array at each stage
     * of the sorting process.
     * 
     * @param intArray The numbers to be sorted.
     * @return An ArrayList containing int arrays, with each int array representing a 'frame' in the sorting process.
     */
    public ArrayList<int[]> getMergeHistory(int[] intArray) {
        mergeSort(intArray, 0, intArray.length - 1);
        ArrayList<int[]> result = (ArrayList) mergeSortOutput.clone();
        mergeSortOutput = new ArrayList();
        return result;
    }
}
