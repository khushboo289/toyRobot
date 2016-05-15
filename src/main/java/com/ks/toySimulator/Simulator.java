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
		String[] arr, move;
				
		//check if table is valid
		if(table == null){
			System.out.println("invalid table rows and columns");
			return null;
		}
		
		arr = inputString.split(" ");
		int x = 0, y = 0;
		String direction = null;
        try {
        	move = arr[1].split(",");
            x = Integer.parseInt(move[0]);
            y = Integer.parseInt(move[1]);
            direction = move[2];
            
            if (!validDirection.contains(direction)){
            	output = "Invalid move";
            }
            
            if (!isvalidPosition(x, y)){
            	output = "Invalid move";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            output = "Invalid move";
        }
		
		//checking for valid moves
		if (validValues.contains(arr[0])){
			
			String command = arr[0];
			
			switch(command){
				case "PLACE":
		            robot.setPosition(x, y, direction);
		        break;
				case "MOVE":
					getNextPlace(robot.getX(), robot.getY(), robot.getDirection());
					if (robot == null || !isvalidPosition(robot.getX(), robot.getY())){
						output = "false";
					} else {
						output = "Output: "+ this.robot.getX() + ", "+ this.robot.getY()+ ", "+this.robot.getDirection();
					}
				break;
				case "LEFT":
					robot.moveLeft(robot.getDirection());
				break;
				case "RIGHT":
					robot.moveRight(robot.getDirection());
				break;
				case "REPORT":
					if (robot.getDirection() != null){
						output = "Output: "+ this.robot.getX() + ", "+ this.robot.getY()+ ", "+this.robot.getDirection();
					} else {
						output = "Invalid move";
					}
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

	public void getNextPlace(int x, int y, String direction) {
	    
	    if (robot.direction != null){
	    	
			switch (direction) {
				
				case "NORTH":
					robot.changeCoordinates(0, 1);
				break;
				case "SOUTH":
					robot.changeCoordinates(0, -1);
				break;    
				case "EAST":
					robot.changeCoordinates(1, 0);
				break;
				case "WEST":
				 	robot.changeCoordinates(-1, 0);
				break;
			}
	    }
    }

}
