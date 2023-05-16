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
    
    public Color getColor(String color){
        Color newColor;
        switch (color) {
            case "orange":
                newColor=new Color(255, 87, 4);
                return newColor;
            case "pink":
                newColor=new Color(251, 93, 211);
                return newColor;
            case "white":
                newColor=new Color(255, 255, 255);
                return newColor;
            case "yellow":
                newColor=new Color(254, 251, 14);
                return newColor;
            case "black":
                newColor=new Color(0, 0, 0);
                return newColor;
            case "blue":
                newColor=new Color(0, 0, 255);
                return newColor;
            case "cyan":
                newColor=new Color(15, 253, 242);
                return newColor;
            case "gray":
                newColor=new Color(132, 138, 138);
                return newColor;
            case "green":
                newColor=new Color(0, 255, 0);
                return newColor;
            case "red":
                newColor=new Color(255, 0, 0);
                return newColor;
            case "purple":
                newColor=new Color(151, 10, 21);
                return newColor;
            default:
                newColor=new Color(0, 0, 0);
                return newColor;
        }
    }
    
    @Override
    public void draw(Graphics g) {
        ImageIcon imagen=new ImageIcon(getClass().getResource("tortuga-removebg-preview.png"));         
        g.setColor(new Color(128,64,0));         
        g.drawImage(imagen.getImage(),x, y, width, height,null);
        drawTrace(g);
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
    
    
//    int ox = x;
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

    public void setTraces(ArrayList<Trace> traces) {
        this.traces = traces;
    }

    public ArrayList<Trace> getTraces() {
        return traces;
    }
    
    
}
