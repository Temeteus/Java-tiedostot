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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void accelerate(int amount) {
        speed += amount;
    }

    public void decelerate(int amount) {
        speed -= amount;

        if (speed < 0) {
            speed = 0;
        }
    }

    public void status() {
        System.out.println(
            "Auto: " + brand + " " + model +
            ", Nopeus: " + speed + " km/h"
        );
    }
}