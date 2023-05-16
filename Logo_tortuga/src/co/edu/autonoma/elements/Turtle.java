/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author HP-15EC107LA
 */
public class Turtle extends Sprite {
    private int angle;
    private int xOld;
    private int yOld;
    private ArrayList<Trace> traces;
    
    public Turtle(int x, int y) {
        super(x, y, 70, 70);
        angle= 0;
        this.traces = new ArrayList<>(); 
    }
    
    public void addTraces(int x1, int y1, int x2, int y2){
        Trace t = new Trace(x1, y1, x2+width/2, y2+height);
        traces.add(t);
    }
    
    public void drawTrace(Graphics g){
        for(Trace actual: traces){
            actual.draw(g);
        }
    }

    @Override
    public void draw(Graphics g) {
        ImageIcon imagen=new ImageIcon(getClass().getResource("tortuga-removebg-preview.png"));         
        g.setColor(new Color(128,64,0));         
        g.drawImage(imagen.getImage(),x, y, width, height,null);
        drawTrace(g);
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
        xOld= x;
        yOld = y;
        x+= Math.sin(Math.toRadians(angle))*value;
        y-= Math.cos(Math.toRadians(angle))*value;
        addTraces(xOld+width/2, yOld+height,x,y);
    }
    
    public void moveBk(int value){
        xOld= x;
        yOld = y;
        x-= Math.sin(Math.toRadians(angle))*value;
        y+= Math.cos(Math.toRadians(angle))*value;
        addTraces(xOld+width/2, yOld+height,x,y);
    }
    
    public void rightTurn(int value){
        angle+= value;
    }
    
    public void leftTurn(int value){
        angle-= value;
    }
    

//        int ox = x;
//        int oy = y;
//
//        if(x < this.area.getX())
//            x = this.area.getX();
//            
//        if(y < this.area.getY())
//            y = this.area.getY();
//
//        if(x + this.width > this.area.getWidth())
//            x = this.area.getWidth() - this.width;
//        
//        if(y + this.height > this.area.getHeight())
//            y = this.area.getHeight()- this.height;
//        
//        if(x == ox & y == oy)
//            return false;
//        
//        return true;
    
    
}
