package main;
import java.util.ArrayList;

public class Safe {

    private String pinCode;
    private ArrayList<String> safeFolder;

    public Safe(String pincode) {
        this.pinCode = pincode;
        this.safeFolder = new ArrayList<>();
    }

    public void changePin(String code) {
        pinCode = code;
    }

    public void addItem(String item) {
        safeFolder.add(item);
    }

    public ArrayList<String> getList(String code) {
        if (pinCode.equals(code)) {
            return safeFolder;
        }
        return null;
    }
}