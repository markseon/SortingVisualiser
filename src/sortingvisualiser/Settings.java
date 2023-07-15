/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualiser;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Mark
 */
public class Settings implements Serializable{
    private Color backgroundColour;
    private Color barColour;
    private int length;
    private int range;
    private int frameRate;
    private int sortingAlgorithm;

    public Color getBackgroundColour() {
        return backgroundColour;
    }

    public Color getBarColour() {
        return barColour;
    }

    public int getLength() {
        return length;
    }

    public int getRange() {
        return range;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public int getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    public void setBackgroundColour(Color backgroundColour) {
        this.backgroundColour = backgroundColour;
    }

    public void setBarColour(Color barColour) {
        this.barColour = barColour;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    public void setSortingAlgorithm(int sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
    
    
}
