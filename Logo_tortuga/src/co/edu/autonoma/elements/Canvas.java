/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import co.edu.autonoma.Exceptions.CanNotBeRepeatedException;
import co.edu.autonoma.instructions.BackwardInstruction;
import co.edu.autonoma.instructions.ForwardInstruction;
import co.edu.autonoma.instructions.HomeInstruction;
import co.edu.autonoma.instructions.Instruction;
import co.edu.autonoma.instructions.LeftTurnInstruction;
import co.edu.autonoma.instructions.LoadInstruction;
import co.edu.autonoma.instructions.RepeatInstruction;
import co.edu.autonoma.instructions.ResetInstruction;
import co.edu.autonoma.instructions.RightTurnInstruction;
import co.edu.autonoma.instructions.SaveInstruction;
import co.edu.autonoma.instructions.SetColorInstruction;
import java.awt.Color;
import java.awt.Graphics;
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
    }
    
    public void handleInstruction(){
        if(instruction instanceof BackwardInstruction){
            int value= ((BackwardInstruction)instruction).getValue();
            turtle.moveBk(value);
        }
        if(instruction instanceof ForwardInstruction){
            int value= ((ForwardInstruction)instruction).getValue();
            turtle.moveFd(value);
        }
        if(instruction instanceof LeftTurnInstruction){
            int value= ((LeftTurnInstruction)instruction).getValue();
            turtle.leftTurn(value);
        }
        if(instruction instanceof RightTurnInstruction){
            int value= ((RightTurnInstruction)instruction).getValue();
            turtle.rightTurn(value);
        }
        if(instruction instanceof HomeInstruction){
            
        }
        if(instruction instanceof SaveInstruction){
            
        }
        if(instruction instanceof ResetInstruction){
            
        }
        if(instruction instanceof SetColorInstruction){
            
        }
        if(instruction instanceof RepeatInstruction){
            repeat();
        }
    }
    
    public void repeat(){
        ArrayList<String> array= ((RepeatInstruction)instruction).getArray();
        String comand= array.get(0);
        for(int i=0; i< ((RepeatInstruction)instruction).getValue(); i++){
            if(comand.equals("fd") || comand.equals("forward")){
                int value= ((ForwardInstruction)instruction).getValue();
                turtle.moveFd(value);
            }else if(comand.equals("bk") || comand.equals("backward")){
                int value= ((BackwardInstruction)instruction).getValue();
                turtle.moveBk(value);
            }else if(comand.equals("lt") || comand.equals("leftturn")){
                int value= ((LeftTurnInstruction)instruction).getValue();
                turtle.leftTurn(value);
            }else if(comand.equals("rt") || comand.equals("rightturn")){
                int value= ((RightTurnInstruction)instruction).getValue();
                turtle.rightTurn(value);
            }else{
                throw new CanNotBeRepeatedException();
            }
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
