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
 * The SortingVisualiser class allows the user view a visualisation of several
 * sorting algorithms based on parameters that they supply.
 *
 * This class launches the GUI and contains methods to respond to actions
 * initiated by the user.
 *
 * @author Mark Seon
 */
public class SortingVisualiser {
    
    /**
     * The default background colour for the display.
     */
    public final Color DEFAULT_BACKGROUND_COLOUR;
    /**
     * The default bar colour for the display.
     */
    public final Color DEFAULT_BAR_COLOUR;
    /**
     * The name of the file that settings are saved to.
     */
    public final String SAVE_FILENAME;
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
    private Settings settings;
    private boolean showBubbles;
    private Timer timer;

    /**
     * Creates a new Sorting Visualiser
     */
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
    /**
     * Deletes the settings file and resets this objects fields to their default values.
     */
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

    /**
     * Returns a list containing the names of the available sorting algorithms.
     *
     * @return A list of the available sorting algorithms
     */
    public String[] getAlgorithmNames() {
        return algorithmNames;
    }

    /**
     * Returns the current frame rate used during playback.
     *
     * @return The frame rate used during playback.
     */
    public int getFrameRate() {
        return frameRate;
    }

    /**
     * Sets the frame rate used during playback.
     *
     * @param frameRate The new frame rate to be used during playback.
     */
    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
        if (isRunning) {
            timer.setDelay(1000 / frameRate);
        }
    }

    /**
     * Returns the length of the generated random number list.
     *
     * @return The length of the random number list.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the generated random number list.
     *
     * @param length The length of the random number list.
     */
    public void setLength(int length) {
        if (this.gui != null) {
            this.length = length;
            regenerate();
        }
    }

    /**
     * Gets the range of numbers in the generated random number list.
     *
     * @return The range of numbers to be generated.
     */
    public int getRange() {
        return range;
    }

    /**
     * Sets the range of numbers in the generated random number list.
     *
     * @param range The range of numbers to be generated.
     */
    public void setRange(int range) {
        if (this.gui != null) {
            this.range = range;
            regenerate();
        }
    }

    /**
     * Returns the index of the currently selected algorithm in the
     * algorithmNames list.
     *
     * @return The currently selected sorting algorithm.
     */
    public int getSelectedAlgorithm() {
        return selectedAlgorithm;
    }

    /**
     * Sets the selected sorting algorithm.
     *
     * @param selectedAlgorithm The selected sorting algorithm as an index in
     * the algorithmNames list.
     */
    public void setSelectedAlgorithm(int selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
        if (isRunning) {
            stop();
        } else if (gui != null) {
            gui.updateDisplay(randomNumbers);
        }
    }

    /**
     * Returns whether individual numbers "bubbling" to the top is shown for
     * bubble sort.
     *
     * @return True if "bubbles" are shown in bubble sort.
     */
    public boolean isShowBubbles() {
        return showBubbles;
    }

    /**
     * Sets whether individual numbers "bubbling" to the top is shown for bubble
     * sort.
     *
     * @param showBubbles Whether bubbles should be shown in bubble sort.
     */
    public void setShowBubbles(boolean showBubbles) {
        this.showBubbles = showBubbles;
    }

    /**
     * Pauses playback.
     */
    public void pause() {
        if (isRunning) {
            timer.stop();
        }
    }

    /**
     * Begins playback
     */
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

    /**
     * Generates a new random number list and updates the display.
     */
    public void regenerate() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
        }
        randomNumbers = generateRandomArray();
        sortNumbers();
        gui.updateDisplay(randomNumbers);
    }
    /**
     *  Saves the user's settings as a text file containing a serialised Settings object.
     * @param backgroundColour The background colour to be saved.
     * @param barColour The bar colour to be saved.
     */
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

    /**
     * Stops playback and displays the unsorted list.
     */
    public void stop() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
        }
        gui.updateDisplay(randomNumbers);

    }
    
    /**
     *  Generates a new array of random integers
     * @return An array of random integers
     */
    private int[] generateRandomArray() {
        Random rand = new Random();
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            output[i] = rand.nextInt(range);
        }

        return output;
    }
    /**
     * Resets the length, range, selectedAlgorithm and frameRate fields to their
     * default values.
     */
    private void initDefaults() {
        length = 100;
        range = 100;
        selectedAlgorithm = 0;
        frameRate = 30;
    }
    
    
    /**
     * Attempts to load settings from a text file.
     */
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
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    /**
     *  Sorts the random number array using several sorting algorithms. 
     */
    private void sortNumbers() {
        bubbleSortedBubbles = algorithms.bubbleSort(randomNumbers.clone(), true);
        bubbleSorted = algorithms.bubbleSort(randomNumbers.clone(), false);
        insertionSorted = algorithms.insertionSort(randomNumbers.clone());
        mergeSorted = algorithms.getMergeHistory(randomNumbers.clone());
        System.gc(); // Used to fix issue where heap size would remain high after sorting
    }
}
