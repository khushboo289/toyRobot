package com.ks.toySimulator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Simulator {
	
	Robot robot;
	
	Table table;
	
	//Valid move values
	private static final Set<String> validValues = new HashSet<String>(Arrays.asList(
	 new String[] {"MOVE","PLACE","REPORT","LEFT","RIGHT"}
	));

	private static final Set<String> validDirection = new HashSet<String>(Arrays.asList(
	 new String[] {"NORTH","SOUTH","EAST","WEST"}
	));
	
	public Simulator(Robot robot, Table table) {
		this.robot = robot;
		this.table = table;
	}

	public String proceed(String inputString) {
		
		String output = null;
				
		//check if table is valid
		if(table == null){
			System.out.println("invalid table rows and columns");
			return null;
		}
		
		String arr[] = inputString.split(" ");
		
		//checking for valid moves
		if (validValues.contains(arr[0])){
			
			String command = arr[0];
			
			switch(command){
				case "PLACE":
					String[] move = arr[1].split(",");
		            try {
		                int x = Integer.parseInt(move[0]);
		                int y = Integer.parseInt(move[1]);
		                String direction = move[2];
		                
		                if (!validDirection.contains(direction)){
		                	System.out.println("Invalid direction");
		                	return null;
		                }
		                
		                if (!isvalidPosition(x, y)){
		                	System.out.println("Invalid move");
		                	return null;
		                }
		                robot.setPosition(x, y, direction);
		            } catch (Exception e) {
		                System.out.println(e.getMessage());
		            }
		        break;
				case "MOVE":
				break;
				case "LEFT":
				break;
				case "RIGHT":
				break;
				case "REPORT":
					output = "Output: "+ this.robot.getX() + ", "+ this.robot.getY()+ ", "+this.robot.getDirection();
				break;
				default:
					System.out.println("Invalid Move");
			}
		} else {
			System.out.println("Invalid move");
		}
		return output;
	}

	private boolean isvalidPosition(int x, int y){
		return !(x > this.table.columns || x < 0 || y > this.table.rows || y <0);
	}

}
