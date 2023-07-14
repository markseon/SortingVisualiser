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

    public final Color DEFAULT_BACKGROUND_COLOUR;
    public final Color DEFAULT_BAR_COLOUR;
    private final String[] algorithmNames;
    private final SortingAlgorithms algorithms;
    private ArrayList<int[]> bubbleSorted;
    private ArrayList<int[]> bubbleSortedBubbles;
    private int frameRate;
    private final GUI gui;
    private ArrayList<int[]> insertionSorted;
    private boolean isRunning;
    private int length;
    private ArrayList<int[]> mergeSorted;
    private int[] randomNumbers;
    private int range;
    private int selectedAlgorithm;
    private boolean showBubbles;
    private Timer timer;

    public SortingVisualiser() {
        isRunning = false;
        DEFAULT_BACKGROUND_COLOUR = Color.BLACK;
        DEFAULT_BAR_COLOUR = Color.WHITE;
        length = 100;
        range = 100;
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

    public String[] getAlgorithmNames() {
        return algorithmNames;
    }

    public int getFrameRate() {
        return frameRate;
    }
    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
        if (isRunning) {
            timer.setDelay(1000 / frameRate);
        }
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
        regenerate();
    }

    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
        regenerate();
    }

    public int getSelectedAlgorithm() {
        return selectedAlgorithm;
    }
    public void setSelectedAlgorithm(int selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
        if (isRunning) {
            stop();
        }
    }

    public boolean isShowBubbles() {
        return showBubbles;
    }
    public void setShowBubbles(boolean showBubbles) {
        this.showBubbles = showBubbles;
    }

    public void pause() {
        if (isRunning) {
            timer.stop();
        }
    }

    public void playSequence() {
        if (isRunning) {
            timer.start();
        } else {
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
            Iterator<int[]> it = selectedList.iterator();
            timer = new Timer(1000 / frameRate, (ActionEvent e) -> {
                isRunning = true;
                if (it.hasNext()) {
                    gui.updateDisplay(it.next());
                } else {
                    ((Timer) e.getSource()).stop();
                    isRunning = false;
                }
            });
            timer.start();
        }
    }

    public void regenerate() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
        }
        randomNumbers = generateRandomArray();
        sortNumbers();
        gui.updateDisplay(randomNumbers);
    }


    public void stop() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
            gui.updateDisplay(randomNumbers);
        }
    }

    private int[] generateRandomArray() {
        Random rand = new Random();
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            output[i] = rand.nextInt(range);
        }

        return output;
    }

    private void sortNumbers() {
        bubbleSortedBubbles = algorithms.bubbleSort(randomNumbers.clone(), true);
        bubbleSorted = algorithms.bubbleSort(randomNumbers.clone(), false);
        insertionSorted = algorithms.insertionSort(randomNumbers.clone());
        mergeSorted = algorithms.getMergeHistory(randomNumbers.clone());
    }

}
