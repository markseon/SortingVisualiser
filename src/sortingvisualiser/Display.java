package sortingvisualiser;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Represents a canvas upon which a background and bars are painted.
 * @author Mark Seon
 */
public class Display extends JPanel {

    private Color backgroundColour, barColour;
    int[] displayData;
    double heightScale;
    double widthScale;
    int width;
    int height;
    
    /**
     * Constructs a new Display object.
     */
    public Display() {
        backgroundColour = Color.BLACK;
        barColour = Color.WHITE;
        heightScale = 1;
        widthScale = 1;
        width = 1280;
        height = 720;
    }
    
    /**
     *  Rescales the display according to the displayData and draws the displayData.
     * 
     * @param g The display that is being painted 
     */
    @Override
    public void paintComponent(Graphics g) {
        // Scale the image
        if (displayData != null) { // Check that there is display data before updating scaling
            updateScaling(); // Update heightScale and widthScale
        }
        Graphics2D g2D = (Graphics2D) g.create(); // Cast g to Graphics2D
        g2D.scale(widthScale, heightScale); // Scale the canvas
        g2D.translate(0, (-height * heightScale) + height); // Translate the canvas verically

        // Draw the background
        g2D.setColor(backgroundColour);
        g2D.fillRect(0, this.getHeight() - height, width, height);
        if (displayData != null) {
            paintBars(g2D);
        }
    }
    
    /**
     * Paints bars on the display.
     * @param g the display upon which the bars are being drawn
     */
    private void paintBars(Graphics2D g) {
        g.setColor(barColour);
        for (int x = 0; x < displayData.length; x++) {
            int barHeight = displayData[x];
            int y = getHeight() - barHeight;
            g.fillRect(x, y, 1, barHeight);
        }
    }
    
    /**
     *  Updates the displayData variable and repaints the display.
     * @param intArray The new display data
     */
    public void update(int[] intArray) {
        displayData = intArray;
        updateScaling();
        repaint();
    }
    
    /**
     * Updates the scaling variables used to scale the drawn image to fill the display.
     */
    private void updateScaling() {
        int largest = displayData[0];
        for (int i : displayData) {
            largest = i > largest ? i : largest;
        }
        width = displayData.length;
        height = largest;
        heightScale = (double) getHeight() / largest;
        widthScale = (double) getWidth() / displayData.length;

    }
    
    /**
     * Sets the background colour of the display.
     * @param backgroundColour The new background colour.
     */
    public void setBackgroundColour(Color backgroundColour) {
        this.backgroundColour = backgroundColour;
    }
    
    /**
     * Sets the colour of bars painted on the display
     * @param barColour the new bar colour
     */
    public void setBarColour(Color barColour) {
        this.barColour = barColour;
    }
    
    /**
     *  Returns the current background colour of this display.
     * 
     * @return This display's current background colour
     */
    public Color getBackgroundColour() {
        return backgroundColour;
    }
    
    /**
     * Returns the current bar colour of this display.
     * 
     * @return This display's current bar colour.
     */
    public Color getBarColour() {
        return barColour;
    }

}
