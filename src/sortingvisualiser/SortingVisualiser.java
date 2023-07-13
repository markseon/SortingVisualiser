/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sortingvisualiser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Mark
 */
public class SortingVisualiser {

    private int length, range;
    private SortingAlgorithms algorithms;
    private ArrayList<int[]> bubbleSorted;
    private ArrayList<int[]> bubbleSortedBubbles;
    private ArrayList<int[]> insertionSorted;
    private ArrayList<int[]> mergeSorted;
    private int[] randomNumbers;
    private boolean showBubbles;
    private GUI gui;
    private int selectedAlgorithm;
    private int frameRate;
    private String[] algorithmNames;
    public final Color BACKGROUND_COLOUR;
    public final Color BAR_COLOUR;

    public SortingVisualiser() {
        BACKGROUND_COLOUR = Color.BLACK;
        BAR_COLOUR = Color.WHITE;
        length = 20;
        range = 20;
        algorithms = new SortingAlgorithms();
        showBubbles = false;
        algorithmNames = new String[]{"Bubble sort", "Insertion sort", "Merge sort"};
        selectedAlgorithm = 0;
        frameRate = 30;
        randomNumbers = generateRandomArray();
        sortNumbers();
        gui = new GUI(this);
        gui.setVisible(true);
        gui.updateDisplay(randomNumbers);

//        display = new Display(1920, 1080);
//        sortNumbers();
//        
//        playSequence(bubbleSorted, 30);
//        playSequence(insertionSorted, 30);
//        playSequence(mergeSorted, 30);
    }

    public int getLength() {
        return length;
    }

    public int getRange() {
        return range;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setRange(int range) {
        this.range = range;
    }

    private final int[] generateRandomArray() {
        Random rand = new Random();
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            output[i] = rand.nextInt(range);
        }

        return output;
    }

    public void regenerate() {
        randomNumbers = generateRandomArray();
        sortNumbers();
        gui.updateDisplay(randomNumbers);
    }

    private void sortNumbers() {
        bubbleSortedBubbles = algorithms.bubbleSort(randomNumbers.clone(), true);
        bubbleSorted = algorithms.bubbleSort(randomNumbers.clone(), false);
        insertionSorted = algorithms.insertionSort(randomNumbers.clone());
        mergeSorted = algorithms.getMergeHistory(randomNumbers.clone());
    }

    public void playSequence() {
        ArrayList<int[]> selectedList = switch (selectedAlgorithm) {
            case 0 ->
                showBubbles ? bubbleSortedBubbles : bubbleSorted;
            case 1 ->
                insertionSorted;
            case 2 ->
                mergeSorted;
            default ->
                new ArrayList<>();
        };
//        long delayNs = (long) (1000000000 / frameRate);
//        long currentTime = System.nanoTime();
//        for (int[] frame : selectedList) {
//            gui.updateDisplay(frame);
//            while (System.nanoTime() < currentTime + delayNs) {
//            }
//            currentTime = System.nanoTime();
//            System.out.println("Frameplayed");
//
//        }
        Iterator<int[]> it = selectedList.iterator();
        Timer timer = new Timer(1000 / frameRate, (ActionEvent e) -> {
            if (it.hasNext()) {
                gui.updateDisplay(it.next());
            } else {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }

    public void setShowBubbles(boolean showBubbles) {
        this.showBubbles = showBubbles;
    }

    public boolean isShowBubbles() {
        return showBubbles;
    }

    public int getSelectedAlgorithm() {
        return selectedAlgorithm;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setSelectedAlgorithm(int selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
    }

    public String[] getAlgorithmNames() {
        return algorithmNames;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

}
