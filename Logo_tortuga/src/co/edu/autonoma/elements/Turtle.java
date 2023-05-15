/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author HP-15EC107LA
 */
public class Turtle extends Sprite {
    private int angle;
    private int x2;
    private int y2;
    
    public Turtle(int x, int y) {
        super(x, y, 70, 70);
        angle= 270;
    }

    @Override
    public void draw(Graphics g) {
        ImageIcon imagen=new ImageIcon(getClass().getResource("tortuga-removebg-preview.png"));         
        g.setColor(new Color(128,64,0));         
        g.drawImage(imagen.getImage(),x, y, width, height,null);
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
    
    public void moveFd(int value){
        x+= Math.sin(angle)*value;
        y-= Math.cos(angle)*value;
    }
    
    public void moveBk(int value){
        x-= Math.sin(angle)*value;
        y+= Math.cos(angle)*value;
    }
    
    public void rightTurn(int value){
        angle+= value;
    }
    
    public void leftTurn(int value){
        angle-= value;
    }
    
    public boolean move(String command, int value){
        if(command.equals("fd") | command.equals("forward")){
            moveFd(value);
        }
        if(command.equals("bk") | command.equals("backward")){
            moveBk(value);
        }
        if(command.equals("rt") | command.equals("rightturn")){
            rightTurn(value);
        }
        if(command.equals("lt") | command.equals("leftturn")){
            leftTurn(value);
        }
        
        int ox = x;
        int oy = y;

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
