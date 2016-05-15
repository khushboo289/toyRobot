package com.ks.toySimulator;

public class Table {
	int rows;
	int columns;
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Table(int i, int j) {
		this.rows = i;
		this.columns = j;
	}

}
