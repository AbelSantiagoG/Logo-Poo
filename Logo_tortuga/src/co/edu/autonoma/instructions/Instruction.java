/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.autonoma.instructions;

/**
 *
 * @author migue
 */
public class Instruction {
    private String command;
    private int amount;

    public Instruction(String command, int amount) {
        this.command = command;
        this.amount = amount;
    }

    public String getCommand() {
        return command;
    }
    
    public void setCommand(String command) {
        this.command = command;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
      
}
