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
    private int value;
    private ArrayList<String> array;
            
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the array
     */
    public ArrayList<String> getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(ArrayList<String> array) {
        this.array = array;
    }
}
