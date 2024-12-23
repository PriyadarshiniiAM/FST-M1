package activities;

public class Car {
	String colour;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	Car(String colour, String transmission, int make) {
		this.colour = colour;
		this.transmission = transmission;
		this.make = make;
		this.tyres=4;
		this.doors=4;
	}
	public void displayCharacteristics() {
		System.out.println("colour:" +colour);
		System.out.println("transmission type:" +transmission);
		System.out.println("Year of Making:" +make);
		System.out.println("No. of tyres:" +tyres);
		System.out.println("No. of doors:" +doors);
	}
	public void accelerate() {
		System.out.println("Car is movind forward");
	}
	public void brake() {
		System.out.println("Car is stopped");
	}
}
