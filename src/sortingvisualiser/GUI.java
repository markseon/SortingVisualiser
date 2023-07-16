/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sortingvisualiser;

/**
 *
 * @author Mark
 */
import java.awt.Color;
import javax.swing.JColorChooser;

public class GUI extends javax.swing.JFrame {

    private final SortingVisualiser sortingVisualiser;

    public GUI(SortingVisualiser sortingVisualiser) {
        this.sortingVisualiser = sortingVisualiser;
        initDesign();
        initComponents();
        initFields();
    }

    private void initDesign() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void initFields() {
        showBubbles.setState(sortingVisualiser.isShowBubbles());
        for (String algorithm : sortingVisualiser.getAlgorithmNames()) {
            algorithmList.addItem(algorithm);
        }
        display.setBackgroundColour(sortingVisualiser.DEFAULT_BACKGROUND_COLOUR);
        display.setBarColour(sortingVisualiser.DEFAULT_BAR_COLOUR);
        updateFields();
    }

    public void updateFields() {
        algorithmList.setSelectedIndex(sortingVisualiser.getSelectedAlgorithm());
        length.setText(String.valueOf(sortingVisualiser.getLength()));
        lengthSlider.setValue(sortingVisualiser.getLength());
        range.setText(String.valueOf(sortingVisualiser.getRange()));
        rangeSlider.setValue(sortingVisualiser.getRange());
        playbackSpeedSlider.setValue(sortingVisualiser.getFrameRate());
        playbackSpeed.setText(String.valueOf(sortingVisualiser.getFrameRate()));
    }

    public void updateDisplay(int[] frame) {
        display.update(frame);
    }

    public void setBackgroundColour(Color backgroundColour) {
        display.setBackgroundColour(backgroundColour);
    }

    public void setBarColour(Color barColour) {
        display.setBarColour(barColour);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        algorithmList = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        play = new javax.swing.JButton();
        regenerate = new javax.swing.JButton();
        length = new javax.swing.JTextField();
        range = new javax.swing.JTextField();
        playbackSpeedSlider = new javax.swing.JSlider();
        playbackSpeed = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rangeSlider = new javax.swing.JSlider();
        lengthSlider = new javax.swing.JSlider();
        display = new sortingvisualiser.Display();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        showBubbles = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        backgroundColour = new javax.swing.JMenuItem();
        barColour = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sorting Visualiser");
        setMinimumSize(new java.awt.Dimension(760, 480));
        setName("mainWindow"); // NOI18N

        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Sorting Algorithm");

        algorithmList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                algorithmListItemStateChanged(evt);
            }
        });

        jLabel1.setText("Length");

        jLabel3.setText("Range");

        jLabel4.setText("Playback speed");

        play.setText("Play");
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playMousePressed(evt);
            }
        });
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        regenerate.setText("Regenerate numbers");
        regenerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                regenerateMousePressed(evt);
            }
        });
        regenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regenerateActionPerformed(evt);
            }
        });

        length.setEditable(false);

        range.setEditable(false);

        playbackSpeedSlider.setMajorTickSpacing(1);
        playbackSpeedSlider.setMinimum(1);
        playbackSpeedSlider.setMinorTickSpacing(1);
        playbackSpeedSlider.setValue(1);
        playbackSpeedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                playbackSpeedSliderStateChanged(evt);
            }
        });

        playbackSpeed.setEditable(false);
        playbackSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbackSpeedActionPerformed(evt);
            }
        });

        jButton1.setText("Stop");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Pause");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        rangeSlider.setMaximum(1000);
        rangeSlider.setMinimum(10);
        rangeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rangeSliderStateChanged(evt);
            }
        });

        lengthSlider.setMaximum(1000);
        lengthSlider.setMinimum(10);
        lengthSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lengthSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rangeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playbackSpeedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addComponent(play, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(algorithmList, javax.swing.GroupLayout.Alignment.TRAILING, 0, 115, Short.MAX_VALUE)
                            .addComponent(range, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(length, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playbackSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addComponent(regenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lengthSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(algorithmList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(length, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lengthSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(range, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rangeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playbackSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playbackSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(play)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regenerate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        display.setMinimumSize(new java.awt.Dimension(192, 144));
        display.setPreferredSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout displayLayout = new javax.swing.GroupLayout(display);
        display.setLayout(displayLayout);
        displayLayout.setHorizontalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1263, Short.MAX_VALUE)
        );
        displayLayout.setVerticalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );

        optionsMenu.setText("Options");
        optionsMenu.setFocusPainted(true);

        showBubbles.setText("Detailed Bubble Sort");
        showBubbles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showBubblesItemStateChanged(evt);
            }
        });
        optionsMenu.add(showBubbles);
        showBubbles.putClientProperty("CheckBoxMenuItem.doNotCloseOnMouseClick",Boolean.TRUE);

        jMenu1.setText("Change Colour");

        backgroundColour.setText("Background");
        backgroundColour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backgroundColourMousePressed(evt);
            }
        });
        jMenu1.add(backgroundColour);

        barColour.setText("Bar");
        barColour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barColourMousePressed(evt);
            }
        });
        jMenu1.add(barColour);

        optionsMenu.add(jMenu1);

        jMenuItem1.setText("Save Settings");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        optionsMenu.add(jMenuItem1);

        delete.setText("Reset Settings");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteMousePressed(evt);
            }
        });
        optionsMenu.add(delete);

        jMenuBar1.add(optionsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(0, 0, 1551, 701);
    }// </editor-fold>//GEN-END:initComponents

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playActionPerformed

    private void playbackSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playbackSpeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playbackSpeedActionPerformed

    private void playbackSpeedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_playbackSpeedSliderStateChanged
        playbackSpeed.setText(String.valueOf(playbackSpeedSlider.getValue()));
        sortingVisualiser.setFrameRate(playbackSpeedSlider.getValue());
    }//GEN-LAST:event_playbackSpeedSliderStateChanged

    private void algorithmListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_algorithmListItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            sortingVisualiser.setSelectedAlgorithm(algorithmList.getSelectedIndex());
        }
    }//GEN-LAST:event_algorithmListItemStateChanged

    private void playMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMousePressed
        sortingVisualiser.playSequence();
    }//GEN-LAST:event_playMousePressed

    private void regenerateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regenerateMousePressed
        sortingVisualiser.regenerate();
    }//GEN-LAST:event_regenerateMousePressed

    private void showBubblesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showBubblesItemStateChanged
        sortingVisualiser.setShowBubbles(showBubbles.isSelected());
        //optionsMenu.setPopupMenuVisible(true);
        //optionsMenu.setSelected(true);
    }//GEN-LAST:event_showBubblesItemStateChanged

    private void backgroundColourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundColourMousePressed
        Color newColor = JColorChooser.showDialog(null, "Colour", display.getBackgroundColour());
        display.setBackgroundColour(newColor);
        display.repaint();

    }//GEN-LAST:event_backgroundColourMousePressed

    private void barColourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barColourMousePressed
        Color newColor = JColorChooser.showDialog(null, "Colour", display.getBarColour());
        display.setBarColour(newColor);
        display.repaint();
    }//GEN-LAST:event_barColourMousePressed

    private void regenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regenerateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regenerateActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        sortingVisualiser.stop();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        sortingVisualiser.pause();
    }//GEN-LAST:event_jButton2MousePressed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        sortingVisualiser.saveSettings(display.getBackgroundColour(), display.getBarColour());
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMousePressed
        sortingVisualiser.deleteSettings();
    }//GEN-LAST:event_deleteMousePressed

    private void rangeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rangeSliderStateChanged
        range.setText(String.valueOf(rangeSlider.getValue()));
        if (!rangeSlider.getValueIsAdjusting()) {
            sortingVisualiser.setRange(rangeSlider.getValue());
        }
    }//GEN-LAST:event_rangeSliderStateChanged

    private void lengthSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lengthSliderStateChanged
        length.setText(String.valueOf(lengthSlider.getValue()));
        if (!lengthSlider.getValueIsAdjusting()) {            
            sortingVisualiser.setLength(lengthSlider.getValue());
        }
    }//GEN-LAST:event_lengthSliderStateChanged

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> algorithmList;
    private javax.swing.JMenuItem backgroundColour;
    private javax.swing.JMenuItem barColour;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JMenuItem delete;
    private sortingvisualiser.Display display;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField length;
    private javax.swing.JSlider lengthSlider;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JButton play;
    private javax.swing.JTextField playbackSpeed;
    private javax.swing.JSlider playbackSpeedSlider;
    private javax.swing.JTextField range;
    private javax.swing.JSlider rangeSlider;
    private javax.swing.JButton regenerate;
    private javax.swing.JCheckBoxMenuItem showBubbles;
    // End of variables declaration//GEN-END:variables
}
