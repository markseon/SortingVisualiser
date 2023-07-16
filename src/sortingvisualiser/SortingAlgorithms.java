/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualiser;

/**
 *
 * @author Mark
 */
import java.util.ArrayList;

public class SortingAlgorithms {

    private ArrayList<int[]> mergeSortOutput;

    public SortingAlgorithms() {
        mergeSortOutput = new ArrayList<>();
    }

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

    public void mergeSort(int[] intArray, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            mergeSort(intArray, leftIndex, midIndex);
            mergeSort(intArray, midIndex + 1, rightIndex);
            merge(intArray, leftIndex, midIndex, rightIndex);
            mergeSortOutput.add(intArray.clone());
        }
    }
    
    public void merge(int[] intArray, int leftIndex, int midIndex, int rightIndex) {
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
    
    public ArrayList<int[]> getMergeHistory(int[] intArray) {
        mergeSort(intArray, 0, intArray.length - 1);
        ArrayList<int[]> result = (ArrayList) mergeSortOutput.clone();
        mergeSortOutput = new ArrayList();
        return result;
    }
}
