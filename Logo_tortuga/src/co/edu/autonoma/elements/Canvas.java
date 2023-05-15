/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import co.edu.autonoma.elements.Exceptions.NegativeValueException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author HP-15EC107LA
 */
public class Canvas extends Sprite implements Dimensionable, Drawable {
    private Turtle turtle;

    public Canvas(int width, int height) {
        super(0, 0, width, height);
        turtle = new Turtle(width/2, height/2);
        turtle.setArea(this);
        turtle.setDrawable(this);
    }
    
    public void handleComands( String [] array){   
        if(array.length == 1){
            
        }
        if(array.length == 2){
            String comand = array[0];
            String value = array[1];
            if(comand.equals("fd") || comand.equals("forward") ||
               comand.equals("bd") || comand.equals("backward")||
               comand.equals("rt") || comand.equals("rightturn")||
               comand.equals("lt") || comand.equals("leftturn")){
               int amount = Integer.parseInt(value);
                if(amount < 0){
                    throw new NegativeValueException();                     
                }else{
                    //turtle.move(comand, amount);
                }
            }
        } 
        
    }
    

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, 389);
        
        turtle.draw(g);
    }

    @Override
    public void redraw() {
        if(drawable != null)
            drawable.redraw();
    }

    @Override
    public void redraw(int x, int y, int width, int height) {
        if(drawable != null)
            drawable.redraw(x, y, width, height);
    }

}
