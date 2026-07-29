package main;

public class Instrument {
    private String manufacturer;
    private int price;

    public Instrument(String manufacturer, int price) {
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public String getDetails() {
        return "Valmistaja: " + manufacturer + ", Hinta: " + price + "€";
    }
}