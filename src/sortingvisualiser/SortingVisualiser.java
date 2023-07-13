/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sortingvisualiser;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mark
 */
public class SortingVisualiser {

    private int length, range;
    private SortingAlgorithms algorithms;
    private ArrayList<int[]> bubbleSorted;
    private ArrayList<int[]> insertionSorted;
    private ArrayList<int[]> mergeSorted;
    private int[] randomNumbers;
    private Display display;
    private boolean showBubbles;
    private GUI gui;

    public SortingVisualiser(int length, int range) {
        this.length = length;
        this.range = range;
        algorithms = new SortingAlgorithms();
        randomNumbers = generateRandomArray(length, range);
        showBubbles = false;
        gui = new GUI(this);
        gui.setVisible(true);
        
//        display = new Display(1920, 1080);
//        sortNumbers();
//        
//        playSequence(bubbleSorted, 30);
//        playSequence(insertionSorted, 30);
//        playSequence(mergeSorted, 30);

    }

    public final int[] generateRandomArray(int length, int range) {
        Random rand = new Random();
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            output[i] = rand.nextInt(range);
        }

        return output;
    }

    private void sortNumbers() {
        bubbleSorted = algorithms.bubbleSort(randomNumbers.clone(), showBubbles);
        insertionSorted = algorithms.insertionSort(randomNumbers.clone());
        mergeSorted = algorithms.getMergeHistory(randomNumbers.clone());
    }

    private void playSequence(ArrayList<int[]> intArrayList, int frameRate) {
        long delayNs = (long) (1000000000 / frameRate);
        long currentTime = System.nanoTime();
        for(int[] frame : intArrayList) {
            display.update(frame);
            while(System.nanoTime() < currentTime + delayNs) {                
            }
            currentTime = System.nanoTime();
            
        }
    }
    
    public void setShowBubbles(boolean showBubbles) {
        this.showBubbles = showBubbles;
    }
}
