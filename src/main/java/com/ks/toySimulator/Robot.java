package com.ks.toySimulator;

public class Robot {
	
	//current x coordinates
	int x;
	
	//current y coordinates
	int y;
	
	//direction
	
	String direction;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setPosition(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction; 	
	}
	
	public void changeCoordinates (int x, int y){
		this.x = this.x + x;
		this.y = this.y + y;
	}

	public void moveLeft(String direction) {
		String newDirection = null;
		switch (direction){
			case "NORTH":
				newDirection = "WEST";
			break;
			case "WEST":
				newDirection = "SOUTH";
			break;
			case "EAST":
				newDirection = "NORTH";
			break;
			case "SOUTH":
				newDirection = "EAST";
			break;
		}
		this.direction = newDirection;
	}

	public void moveRight(String direction) {
		String newDirection = null;
		System.out.println(direction+"direction");
		switch (direction){
			case "NORTH":
				newDirection = "EAST";
			break;
			case "WEST":
				newDirection = "NORTH";
			break;
			case "EAST":
				newDirection = "SOUTH";
			break;
			case "SOUTH":
				newDirection = "WEST";
			break;
		}
		this.direction = newDirection;		
	}
}
