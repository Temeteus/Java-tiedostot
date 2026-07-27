package main;

public class Car {

    private String brand;
    private String model;
    private int speed;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.speed = 0;
    }

    public void setCar(String brand, String model) {
        this.brand = brand;
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