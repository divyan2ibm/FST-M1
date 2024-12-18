public class Car {
    // Instance variables
    private String color;
    private String transmission;
    private int make;
    private int tyres;
    private int doors;

    // Constructor to initialize tyres and doors
    public Car(String color, String transmission, int make) {
        this.color = color;
        this.transmission = transmission;
        this.make = make;
        this.tyres = 4;  // Default value
        this.doors = 4;  // Default value
    }

    // Method to display car characteristics
    public void displayCharacteristics() {
        System.out.println("Car Characteristics:");
        System.out.println("Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make: " + make);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }

    // Method to simulate accelerating the car
    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    // Method to simulate braking the car
    public void brake() {
        System.out.println("Car has stopped.");
    }
}



