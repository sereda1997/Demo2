package com.company;

import java.util.Scanner;

public class Car extends Vehicle {

    private FuelType fuelType;

    public Car(String brand, String model, String date, FuelType fuelType) {
        super(brand, model, date);
        this.fuelType = fuelType;
    }

    public Car() {
    }

    @Override
    public void inPut() {
        Scanner input = new Scanner(System.in);
        super.inPut();
        System.out.println("Choose your car fuel type: ELECTRIC - 1,DIESEL - 2 ,GAS - 3");
        switch (input.nextInt()) {
            case 1:
                setFuelType(FuelType.ELECTRIC);
                break;
            case 2:
                setFuelType(FuelType.DIESEL);
                break;
            case 3:
                setFuelType(FuelType.GAS);

        }

    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Brand: '" + super.getBrand() + "' , Model: " + super.getModel() + "', Date: '" + super.getDate() + "Fuel Type: '" + this.fuelType + "' |||\n";
    }
}
