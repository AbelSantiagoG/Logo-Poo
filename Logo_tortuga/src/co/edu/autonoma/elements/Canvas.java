/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import co.edu.autonoma.instructions.BackwardInstruction;
import co.edu.autonoma.instructions.Instruction;
import java.awt.Color;
import java.awt.Graphics;

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
    }
    
    public void handleInstruction(){
        if(instruction instanceof BackwardInstruction){
            int value= ((BackwardInstruction)instruction).getValue();
            turtle.moveFd(value);
        }
        if(instruction instanceof BackwardInstruction){
            
        }
        if(instruction instanceof BackwardInstruction) ){
            
        }
        if(instruction instanceof BackwardInstruction){
            
        }
        if(instruction instanceof BackwardInstruction){
            
        }
        if(instruction instanceof BackwardInstruction){
            
        }
        if(instruction instanceof BackwardInstruction){
            
        }
    }
    
    public void resetAll(String comand){
        
    }
    
    public void resetPosition(String comand){
        
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, 389);
        
        getTurtle().draw(g);
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

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    /**
     * @return the instruction
     */
    public Instruction getInstruction() {
        return instruction;
    }

    /**
     * @param instruction the instruction to set
     */
    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
    
    
}
