package com.zufe.POSITION;

public class PositionInfo {
	private String name;
	private double x;
	private double y;
	
	PositionInfo(String n, double xi, double yi) {
		name = n;
		x = yi;
		y = xi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
