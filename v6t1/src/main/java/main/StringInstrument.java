package main;

public class StringInstrument extends Instrument {
    private int numberOfStrings;

    public StringInstrument(String manufacturer, int price, int numberOfStrings) {
        super(manufacturer, price);
        this.numberOfStrings = numberOfStrings;
    }

    public void tune() {
        System.out.println(getManufacturer()
                + " soitinta viritettiin "
                + numberOfStrings
                + " kieltä!");
    }
}