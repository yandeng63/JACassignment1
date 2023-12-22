import java.util.Scanner;

//Assignment 1
//Group member: Méthot, Francis; Yang Peng; Yan Deng;

public class Computer {
	private String brand;
	private String model;
	private double price;
	
	private long SN;
	private long SNCounter = 1000000;
	
	private static int numOfComp = 0;
	
	public Computer() {
	}
	
	public Computer(String brand, String model, double price) {// constructor
		this.brand = brand;
		this.model = model;
		this.price = price;
		SN = SNCounter;
		SNCounter ++;
		numOfComp ++;
	}
	
	//getter and setter
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
		
	
	public long getSerialNumber() {
		return SN;
	}
	public void setSerialNumber(long sn) {
		SN = sn;
	}

	
	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", model=" + model + ", price=" + price + ", SN=" + SN + ", SNCounter="
				+ SNCounter + "]";
	}

	public static int findNumberOfCreatedComputer() {
		return numOfComp;
	}
	
	
	public boolean equal(Computer c) {
		if(brand == c.brand && model == c.model && price == c.price) {
			return true;
		}else {
			return false;
		}
	}
}
