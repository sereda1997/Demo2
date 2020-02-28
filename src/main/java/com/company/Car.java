package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Car extends Vehicle  {
     private FuelType fuelType ;
    public Car(String brand, String model, String date, FuelType fuelType) {
        super(brand, model, date);
        this.fuelType = fuelType;
    }
     public Car(){

     }

    @Override
    public void inPut() {
        Scanner input =new Scanner(System.in);
        super.inPut();
        int fuelChoose;
        System.out.println("Choose your car fuel type: ELECTRIC - 1,DIESEL - 2 ,GAS - 3");

        switch (input.nextInt()){
            case 1: setFuelType(FuelType.ELECTRIC);
            break;
            case 2: setFuelType(FuelType.DIESEL);
            break;
            case 3: setFuelType(FuelType.GAS);

        }

    }



    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
        /*Date date = new Date();
        int currentYear = date.getYear();*/
    }

    @Override
    public String toString() {
        return "Brand: '"+this.brand + "' , Model: "+this.model+"', Date: '"+ this.date+ "Fuel Type: '"+ this.fuelType+"' |||\n";
    }
}
