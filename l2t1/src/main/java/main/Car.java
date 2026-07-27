package main;

public class Car {

    private String brand;
    private String model;
    private int speed;

    public Car() {
        brand = "";
        model = "";
        speed = 0;
    }

    public Car(String brand, String model, int speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void accelerate(int amount) {
        if (amount >= 0) {
            speed += amount;
        }
    }

    public void decelerate(int amount) {
        if (amount >= 0) {
            speed -= amount;

            if (speed < 0) {
                speed = 0;
            }
        }
    }

    public void status() {
        System.out.println("Auto: " + brand + " " + model
                + ", Nopeus: " + speed + " km/h");
    }
}