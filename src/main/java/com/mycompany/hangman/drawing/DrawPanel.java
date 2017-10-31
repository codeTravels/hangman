package com.mycompany.hangman.drawing;

import com.mycompany.hangman.gui.View;
import com.mycompany.hangman.model.GameConfig;
import com.mycompany.hangman.model.HangmanGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import javax.swing.BorderFactory;

/**
 *
 * @author Cory
 */
public class DrawPanel extends javax.swing.JPanel implements View
{
    Picture picture = new Picture(getPreferredSize().width, getPreferredSize().height, 10);

    /**
     * Creates new form DrawPanel
     */
    public DrawPanel()
    {
        initComponents();
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

     @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(200,200);
    }

     @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        picture.draw(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt)
    {
        if (evt.getPropertyName().equals(HangmanGame.CLEAR_IMAGE))
        {
            picture.reset();
            repaint();
        }
        else if (evt.getPropertyName().equals(HangmanGame.WRONG_GUESS))
        {
            picture.showEnableNext();
            repaint();
        }
        else if (evt.getPropertyName().equals(HangmanGame.GAME_CONFIG))
        {
            picture.setChancesToGuess(((GameConfig)evt.getNewValue()).getNumGuessesAllowed());
            picture.reset();
            repaint();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
