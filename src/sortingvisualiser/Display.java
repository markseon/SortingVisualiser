/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualiser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Mark
 */
public class Display extends JPanel{
    private Color backgroundColour, barColour;
    int[] displayData;
    int heightScale;
    
    public Display() {
        backgroundColour = Color.BLACK;
        barColour = Color.WHITE;
        heightScale = 1;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // Draw the background
        g.setColor(backgroundColour);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (displayData != null) {
            paintBars(g);
        }
    }
    
    public void paintBars(Graphics g) {
        g.setColor(barColour);
        int barWidth = (int) (getWidth() / displayData.length);
        //System.out.println("Width: " + getWidth());
        //System.out.println("barWidth: " + barWidth);
        for(int i = 0; i < displayData.length; i++) {
            int barHeight = displayData[i] * heightScale;
            int x = i * barWidth;
            int y = getHeight() - barHeight;
            g.fillRect(x, y, barWidth, barHeight);
        }
    }
    
    public void update (int[] intArray) {
        displayData = intArray;
        
        int largest = displayData[0];
        for(int i : intArray) 
        {
            largest = i > largest ? i : largest;
        };
        heightScale = (int) (getHeight() / largest);

        repaint();
    } 

    public void setBackgroundColour(Color backgroundColour) {
        this.backgroundColour = backgroundColour;
    }

    public void setBarColour(Color barColour) {
        this.barColour = barColour;
    }

    public Color getBackgroundColour() {
        return backgroundColour;
    }

    public Color getBarColour() {
        return barColour;
    }
    
}
