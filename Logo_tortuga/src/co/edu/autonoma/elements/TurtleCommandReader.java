/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

import co.edu.autonoma.Exceptions.InvalidInstructionException;
import co.edu.autonoma.Exceptions.NegativeValueException;
import co.edu.autonoma.instructions.BackwardInstruction;
import co.edu.autonoma.instructions.ForwardInstruction;
import co.edu.autonoma.instructions.HomeInstruction;
import co.edu.autonoma.instructions.LeftTurnInstruction;
import co.edu.autonoma.instructions.LoadInstruction;
import co.edu.autonoma.instructions.RepeatInstruction;
import co.edu.autonoma.instructions.ResetInstruction;
import co.edu.autonoma.instructions.RightTurnInstruction;
import co.edu.autonoma.instructions.SaveInstruction;
import co.edu.autonoma.instructions.SetColorInstruction;
import java.util.ArrayList;
import co.edu.autonoma.instructions.SaveInstruction;
import co.edu.autonoma.instructions.SetColorInstruction;
import java.util.ArrayList;

/**
 *
 * @author HP-15EC107LA
 */
public class TurtleCommandReader {
    private Canvas canvas;
    
    public TurtleCommandReader(Canvas canva){
        this.canvas= canva;
        
    }
    
    public void read(String [] array){  
        String comand = array[0];
        if(comand.equals("r")|| comand.equals("reset")){
            ResetInstruction r= new ResetInstruction();
            r.setType("r");
            canvas.handleInstruction(r);
        }else if(comand.equals("h")|| comand.equals("home")){
            HomeInstruction h = new HomeInstruction();
            h.setType("h");
            canvas.handleInstruction(h);
        }else if(comand.equals("fd") || comand.equals("forward")){
            ForwardInstruction fd= new ForwardInstruction();
            try{
                int value= Integer.parseInt(array[1]);
                if(value < 0){
                    throw new NegativeValueException();
                }
                fd.setType("fd");
                fd.setValue(value);
                canvas.handleInstruction(fd);
            }catch( NumberFormatException n){
                
            }
        }else if(comand.equals("bd") || comand.equals("backward")){
            BackwardInstruction bd= new BackwardInstruction();
            bd.setType("bd");
            try{
                int value= Integer.parseInt(array[1]);
                if(value < 0){
                    throw new NegativeValueException();
                }
                bd.setValue(value);
                canvas.handleInstruction(bd);
            }catch( NumberFormatException n){
                
            }
        }else if(comand.equals("rt") || comand.equals("rightturn")){
            RightTurnInstruction rt= new RightTurnInstruction();
            rt.setType("rt");
            try{
                int value= Integer.parseInt(array[1]);
                if(value < 0){
                    throw new NegativeValueException();
                }
                rt.setValue(value);
                canvas.handleInstruction(rt);
            }catch( NumberFormatException n){
                
            }
        }else if(comand.equals("lt") || comand.equals("leftturn")){
            LeftTurnInstruction lt= new LeftTurnInstruction();
            lt.setType("lt");
            try{
                int value= Integer.parseInt(array[1]);
                if(value < 0){
                    throw new NegativeValueException();
                }
                lt.setValue(value);
                canvas.handleInstruction(lt);
            }catch(NumberFormatException n){
                
            }
        }else if(comand.equals("repeat")){
            //repeat 4 [ fd ; 40 ]
            RepeatInstruction rp= new RepeatInstruction();
            rp.setType("repeat");
            rp.setValue(Integer.parseInt(array[1]));
            ArrayList<String> arraylist= new ArrayList<>();
            arraylist.add(array[3]);
            arraylist.add(array[5]);
            rp.setArray(arraylist);
            canvas.handleInstruction(rp);
        }else if(comand.equals("load") || comand.equals("l")){
            LoadInstruction l= new LoadInstruction();
            l.setType("l");
            l.setValue(array[1]);
            canvas.handleInstruction(l);
        }else if(comand.equals("save") || comand.equals("s")){
            SaveInstruction s= new SaveInstruction();
            s.setType("s");
            s.setValue(array[1]);
            canvas.handleInstruction(s);
        }else if(comand.equals("setcolor") || comand.equals("sc")){
            SetColorInstruction sc= new SetColorInstruction();
            sc.setType("sc");
            sc.setValue(array[1]);
            canvas.handleInstruction(sc);
        }else{
              throw new InvalidInstructionException();
          }  
    }
    
}
