package com.mycompany.hangman.drawing.body;

import com.mycompany.hangman.drawing.DrawablePiece;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public class Torso extends DrawablePiece
{
    protected static int WIDTH = 2;
    public static int HEIGHT = 60;

    public Torso(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.BLACK);
        g.drawLine(getX(), getY(), getX(), getY() + HEIGHT);

    }

}
