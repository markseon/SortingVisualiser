/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sortingvisualiser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private Settings settings;
    public final String SAVE_FILENAME;

    public SortingVisualiser() {
        isRunning = false;
        DEFAULT_BACKGROUND_COLOUR = Color.BLACK;
        DEFAULT_BAR_COLOUR = Color.WHITE;

        algorithms = new SortingAlgorithms();
        showBubbles = false;
        algorithmNames = new String[]{"Bubble sort", "Insertion sort", "Merge sort"};

        SAVE_FILENAME = "Settings.txt";
        settings = new Settings();
        initDefaults();
        randomNumbers = generateRandomArray();
        sortNumbers();
        gui = new GUI(this);
        loadSettings();
        gui.setVisible(true);
        gui.updateDisplay(randomNumbers);

    }

    private void initDefaults() {
        length = 100;
        range = 100;
        selectedAlgorithm = 0;
        frameRate = 30;
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

    public void saveSettings(Color backgroundColour, Color barColour) {
        settings.setBackgroundColour(backgroundColour);
        settings.setBarColour(barColour);
        settings.setFrameRate(frameRate);
        settings.setLength(length);
        settings.setRange(range);
        settings.setSortingAlgorithm(selectedAlgorithm);

        File settingsFile = new File(SAVE_FILENAME);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(settingsFile, false))) {
            settingsFile.createNewFile();
            objectOutputStream.writeObject(settings);
            objectOutputStream.flush();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void loadSettings() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(SAVE_FILENAME))) {
            settings = (Settings) objectInputStream.readObject();
            objectInputStream.close();

            gui.setBackgroundColour(settings.getBackgroundColour());
            gui.setBarColour(settings.getBarColour());
            frameRate = settings.getFrameRate();
            length = settings.getLength();
            range = settings.getRange();
            selectedAlgorithm = settings.getSortingAlgorithm();
            gui.updateFields();
            regenerate();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void deleteSettings() {
        File settingsFile = new File(SAVE_FILENAME);
        settingsFile.delete();
        initDefaults();
        gui.updateFields();
        regenerate();
        gui.setBackgroundColour(DEFAULT_BACKGROUND_COLOUR);
        gui.setBarColour(DEFAULT_BAR_COLOUR);
        gui.repaint();
    }
}
