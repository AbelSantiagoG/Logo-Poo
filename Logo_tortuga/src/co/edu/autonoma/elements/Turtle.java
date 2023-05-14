/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author HP-15EC107LA
 */
public class Turtle extends Sprite {

    public Turtle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private boolean isValidPosition(int x, int y)
    {
        if(x >= this.area.getX() &
           x + this.width < this.area.getWidth() &
           y >= this.area.getY() &
           y + this.height <= this.area.getHeight())
            return true;
        
        return false;
    }
    
    public boolean move(int direction)
    {
        int ox = x;
        int oy = y;
        
//        if(direction == KeyEvent.VK_LEFT)
//            x -= step;
//            
//        if(direction == KeyEvent.VK_RIGHT)
//            x += step;
//            
//        if(direction == KeyEvent.VK_UP)
//            y -= step;
//            
//        if(direction == KeyEvent.VK_DOWN)
//            y += step;


        if(x < this.area.getX())
            x = this.area.getX();
            
        if(y < this.area.getY())
            y = this.area.getY();

        if(x + this.width > this.area.getWidth())
            x = this.area.getWidth() - this.width;
        
        if(y + this.height > this.area.getHeight())
            y = this.area.getHeight()- this.height;
        
        if(x == ox & y == oy)
            return false;
        
        return true;
    }
    
}
