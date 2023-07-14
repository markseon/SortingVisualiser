/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualiser;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author Mark
 */
public class Display extends JPanel{
    private Color backgroundColour, barColour;
    int[] displayData;
    double heightScale;
    double widthScale;
    int width;
    int height;
    
    public Display() {
        backgroundColour = Color.BLACK;
        barColour = Color.WHITE;
        heightScale = 1;
        widthScale = 1;
        width = 1280;
        height = 720;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // Scale the image
        updateScaling();
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();
        g2D.scale(widthScale, heightScale);
        g2D.translate(0, (- height * heightScale) + height);
        System.out.println(height);
        // Draw the background
        g2D.setColor(backgroundColour);
        g2D.fillRect(0, this.getHeight() - height, width, height);
        if (displayData != null) {
            paintBars(g2D);
        }
    }
    
    public void paintBars(Graphics2D g) {
        g.setColor(barColour);
        //System.out.println("Width: " + getWidth());
        //System.out.println("barWidth: " + barWidth);
        for(int x = 0; x < displayData.length; x++) {
            int barHeight =  displayData[x];
            int y = getHeight() - barHeight;
            g.fillRect(x, y, 1, barHeight);
        }       
    }
    
    public void update (int[] intArray) {
        displayData = intArray;
        updateScaling();
        repaint();
    }
    
    public void updateScaling() {
        int largest = displayData[0];
        for(int i : displayData) 
        {
            largest = i > largest ? i : largest;
        };
        width = displayData.length;
        height = largest;
        heightScale = (double) getHeight() / largest;
        widthScale = (double) getWidth() / displayData.length;
        //System.out.println(heightScale);
        
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
