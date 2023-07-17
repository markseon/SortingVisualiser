/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualiser;

import java.awt.Color;
import java.io.Serializable;

/**
 *  Stores all savable settings related to the application
 * 
 * @author Mark Seon
 */
public class Settings implements Serializable{
    private Color backgroundColour;
    private Color barColour;
    private int length;
    private int range;
    private int frameRate;
    private int sortingAlgorithm;
    
    /**
     * Returns the saved background colour of the display.
     * 
     * @return The display's background colour
     */
    public Color getBackgroundColour() {
        return backgroundColour;
    }
    
    /**
     *  Returns the saved bar colour of the display.
     * 
     * @return the display's bar colour.
     */
    public Color getBarColour() {
        return barColour;
    }
    
    /**
     * Returns the saved length of the generated random number array.
     * @return the length of the random number array
     */
    public int getLength() {
        return length;
    }
    
    /**
     *  Returns the range numbers generated for the random number array.
     * @return The range of numbers generated 
     */
    public int getRange() {
        return range;
    }
    
    /**
     *  Returns the saved playback speed in frames per second
     * @return The playback speed in frames per second. 
     */
    public int getFrameRate() {
        return frameRate;
    }
    
    /**
     * Returns the saved selected sorting algorithm.
     * @return The selected sorting algorithm.
     */
    public int getSortingAlgorithm() {
        return sortingAlgorithm;
    }
    
    /**
     *  Sets the saved background colour
     * @param backgroundColour The background colour to be saved
     */
    public void setBackgroundColour(Color backgroundColour) {
        this.backgroundColour = backgroundColour;
    }
    
    /**
     * Sets the saved bar colour
     * @param barColour The bar colour to be saved
     */
    public void setBarColour(Color barColour) {
        this.barColour = barColour;
    }
    
    /**
     *  Sets the saved length of the random numbers list. 
     * @param length The number list length to be saved
     */
    public void setLength(int length) {
        this.length = length;
    }
    
    /**
     * Sets the saved range of numbers to be included in the random numbers list.
     * @param range The range of random numbers.
     */
    public void setRange(int range) {
        this.range = range;
    }
    
    /**
     * Sets the saved playback speed in frames per second.
     * @param frameRate The frame rate to be saved.
     */
    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }
    
    /**
     * Sets the saved selected sorting algorithm.
     * @param sortingAlgorithm The sorting algorithm selection to be saved.
     */
    public void setSortingAlgorithm(int sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
    
    
}
