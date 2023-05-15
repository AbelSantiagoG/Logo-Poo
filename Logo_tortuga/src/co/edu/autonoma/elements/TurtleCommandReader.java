/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.elements;

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
            canvas.setInstruction(r);
        }
        if(comand.equals("h")|| comand.equals("home")){
            HomeInstruction h = new HomeInstruction();
            h.setType("h");
            canvas.setInstruction(h);
        }
        if(comand.equals("fd") || comand.equals("forward")){
            ForwardInstruction fd= new ForwardInstruction();
            fd.setType("fd");
            fd.setValue(Integer.parseInt(array[1]));
            canvas.setInstruction(fd);
        }
        if(comand.equals("bd") || comand.equals("backward")){
            BackwardInstruction bd= new BackwardInstruction();
            bd.setType("bd");
            bd.setValue(Integer.parseInt(array[1]));
            canvas.setInstruction(bd);
        }
        if(comand.equals("rt") || comand.equals("rightturn")){
            RightTurnInstruction rt= new RightTurnInstruction();
            rt.setType("rt");
            rt.setValue(Integer.parseInt(array[1]));
            canvas.setInstruction(rt);
        }
        if(comand.equals("lt") || comand.equals("leftturn")){
            LeftTurnInstruction lt= new LeftTurnInstruction();
            lt.setType("lt");
            lt.setValue(Integer.parseInt(array[1]));
            canvas.setInstruction(lt);
        }
        if(comand.equals("repeat")){
            RepeatInstruction rp= new RepeatInstruction();
            rp.setType("repeat");
            rp.setValue(Integer.parseInt(array[1]));
            ArrayList<String> arraylist= new ArrayList<>();
            arraylist.add(array[2]);
            arraylist.add(array[3]);
            canvas.setInstruction(rp);
        }
        
        if(comand.equals("load") || comand.equals("l")){
            LoadInstruction l= new LoadInstruction();
            l.setType("l");
            l.setValue(array[1]);
            canvas.setInstruction(l);
        }
        
        if(comand.equals("save") || comand.equals("s")){
            SaveInstruction s= new SaveInstruction();
            s.setType("s");
            s.setValue(array[1]);
            canvas.setInstruction(s);
        }
        
        if(comand.equals("setcolor") || comand.equals("sc")){
            SetColorInstruction sc= new SetColorInstruction();
            sc.setType("sc");
            sc.setValue(array[1]);
            canvas.setInstruction(sc);
        }
    }
    
}
