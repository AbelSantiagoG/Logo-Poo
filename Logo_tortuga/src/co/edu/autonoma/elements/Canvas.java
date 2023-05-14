/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import java.awt.Graphics;

/**
 *
 * @author HP-15EC107LA
 */
public class Canvas extends Sprite implements Dimensionable, Drawable {
    private Turtle turtle;

    public Canvas(int x, int y, int width, int height) {
        super(x, y, width, height);
        turtle = new Turtle(width/2, height/2);
        turtle.setArea(this);
        turtle.setDrawable(this);
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public void redraw() {
    }

    @Override
    public void redraw(int x, int y, int width, int height) {
    }
    
}
