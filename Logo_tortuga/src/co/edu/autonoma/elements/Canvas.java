/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import co.edu.autonoma.Exceptions.CanNotBeRepeatedException;
import co.edu.autonoma.Exceptions.InvalidInstructionException;
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
    public static final int initialXTurtle= 275;
    public static final int initialYTurtle= 205;
            

    public Canvas(int width, int height) {
        super(0, 0, width, height);
        turtle = new Turtle(initialXTurtle, initialYTurtle);
        turtle.setArea(this);
        turtle.setDrawable(this);
    }
    
    public void handleInstruction(Instruction i){
        if(i instanceof BackwardInstruction){
          int value= ((BackwardInstruction)i).getValue();
          turtle.moveBk(value);
          redraw();
          }else if(i instanceof ForwardInstruction){
              int value= ((ForwardInstruction)i).getValue();
              turtle.moveFd(value);
              redraw();
          }else if(i instanceof LeftTurnInstruction){
              int value= ((LeftTurnInstruction)i).getValue();
              turtle.leftTurn(value);
              redraw();
          }else if(i instanceof RightTurnInstruction){
              int value= ((RightTurnInstruction)i).getValue();
              turtle.rightTurn(value);
              redraw();
          }else if(i instanceof HomeInstruction){
              ArrayList<Trace> oldTraces= this.turtle.getTraces();
              Turtle turtle= new Turtle(initialXTurtle, initialYTurtle);
              setTurtle(turtle);
              turtle.setTraces(oldTraces);
              redraw();
          }else if(i instanceof SaveInstruction){
              
          }else if(i instanceof LoadInstruction){
              
          }else if(i instanceof ResetInstruction){
              Turtle turtle= new Turtle(initialXTurtle, initialYTurtle);
              setTurtle(turtle);
          }else if(i instanceof SetColorInstruction){
              String value= ((SetColorInstruction)i).getValue();
              Color color= turtle.getColor(value);
              
          }else if(i instanceof RepeatInstruction){
              try{
                  repeat(i);
              }catch(CanNotBeRepeatedException e){
                  System.out.println("No se puede repetir esta instrucción");
              }
          }
        
        
    }
    
    public void repeat(Instruction j){
        //repeat 4 [fd 50; rt 90]
        ArrayList<String> array= ((RepeatInstruction)j).getArray();
        for(int h=0; h<((RepeatInstruction)j).getValue(); h++){
            for(int i=0; i<array.size(); i++){
                String comand=(array.get(i)).split(" ")[i];
                int value= Integer.parseInt((array.get(i)).split(" ")[i+1]);
                if(comand.equals("fd") || comand.equals("forward")){
                    turtle.moveFd(value);
                }else if(comand.equals("bd") || comand.equals("backward")){
                    turtle.moveBk(value);
                }else if(comand.equals("lt") || comand.equals("leftturn")){
                    turtle.leftTurn(value);
                }else if(comand.equals("rt") || comand.equals("rightturn")){
                    turtle.rightTurn(value);
                }else{
                    throw new CanNotBeRepeatedException();
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

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }
}
