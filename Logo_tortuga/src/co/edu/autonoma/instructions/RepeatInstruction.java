/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.instructions;

import java.util.ArrayList;

/**
 *
 * @author HP-15EC107LA
 */
public class RepeatInstruction extends Instruction {
    private ArrayList<String> instructions= new ArrayList<>();
    public RepeatInstruction(String command, int amount) {
        super(command, amount);
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }
}
