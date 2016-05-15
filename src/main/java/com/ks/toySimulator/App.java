package com.ks.toySimulator;

import java.io.Console;

/**
 * Main class.
 *
 */
public class App 
{
    public static void main(String[] args){
        
    	Console console = System.console();
    	
    	Table table = new Table(5,5);
    	Robot robot = new Robot();
    	
        Simulator simulator = new Simulator(robot,table);       
        
    	String inputString = console.readLine(": ");
    	try {
    		String out = simulator.proceed(inputString);
    	} catch (Exception e){
    		System.out.println(e);
    	}
    }
}
