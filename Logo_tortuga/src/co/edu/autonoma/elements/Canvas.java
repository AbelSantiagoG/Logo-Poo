/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import co.edu.autonoma.Exceptions.ComandoInvalidoException;
import co.edu.autonoma.Exceptions.NegativeValueException;
import co.edu.autonoma.instructions.ForwardInstruction;
import co.edu.autonoma.instructions.Instruction;
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
    private Instruction instruction;

    public Canvas(int width, int height) {
        super(0, 0, width, height);
        turtle = new Turtle(width/2, height/2);
        turtle.setArea(this);
        turtle.setDrawable(this);
        instruction= new Instruction("", 0);
    }
    
    public void handleComands(String [] array){   
        if(array.length == 1){
            String comand = array[0];
            if(comand.equals("r")|| comand.equals("reset")||
               comand.equals("h")|| comand.equals("home")){
                instruction.setCommand(comand);
                
            }else{
                throw new ComandoInvalidoException();
            }
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
                    instruction.setCommand(comand);
                    instruction.setAmount(amount);
                }
            }
        } 
        
        if(array.length == 5){
            String command = array[0];
            String value= array[1];
            int amount = Integer.parseInt(value);
            if(amount < 0){
                    throw new NegativeValueException();                     
                }else{
                    instruction.setAmount(amount);
                    instruction.setCommand(command);
                    ArrayList<String> instructions = new ArrayList<>();
                    instructions.add(array[2]);
                    instructions.add(array[4]);
                }
        }
    }
    
    public void callInstructions(String comand){
        if(comand.equals("r")|| comand.equals("reset")){
            
        }
        
        if(comand.equals("h")|| comand.equals("home")){
            
        }
        if(comand.equals("fd") || comand.equals("forward")){
            ForwardInstruction instruction= new ForwardInstruction();
            turtle.moveFd(instruction.getAmount());
        }
//        if(){
//            
//        }
//        if(){
//            
//        }
//        if(){
//            
//        }
//        if(){
//            
//        }
//        if(){
//            
//        }
    }
    
    public void resetAll(String comand){
        
    }
    
    public void resetPosition(String comand){
        
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
