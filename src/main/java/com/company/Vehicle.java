package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Vehicle implements Serializable {
    private String brand;
    private String model;
    private String date;
    static LocalDate dateNow = LocalDate.now();

    public Vehicle() {

    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    public Vehicle(String brand, String model, String date) {
        this.brand = brand;
        this.model = model;
        this.date = date;
    }

    public void inPut() {
        Scanner input = new Scanner(System.in);
        System.out.println("Brand");
        setBrand(input.nextLine());
        System.out.println("Enter Model");
        setModel(input.nextLine());
        System.out.println("Enter Date like\"d/MM/yyyy\"");
        try {
            String date ;
            date = input.next();
            LocalDate x = LocalDate.parse(date, formatter);
            setDate(date);
        } catch (Exception e) {
            System.out.println("Wrong date format was inputed");
        }



    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(LocalDate.parse(date, formatter), dateNow);
        return period.getYears();
    }


    @Override
    public String toString() {
        return "Brand: '"+this.brand + "' , Model: '"+this.model+"', Date: "+this.date+" |||\n";
    }

    public static Comparator<Vehicle> BrandComparator = new Comparator<Vehicle>() {

        public int compare(Vehicle s1, Vehicle s2) {

            return s1.brand.compareTo(s2.brand);

            /*For descending order*/
            //return course2 - course1;
        }
    };
    public static Comparator<Vehicle> ModelComparator = new Comparator<Vehicle>() {

        public int compare(Vehicle s1, Vehicle s2) {

            return s1.model.compareTo(s2.model);

            /*For descending order*/
            //return course2 - course1;
        }
    };

    public static ArrayList<Vehicle> carsOlderThan10(ArrayList<Vehicle> oldCars) {
        ArrayList<Vehicle> oldCars1 = new ArrayList<>();
        for (Vehicle x : oldCars
        ) {
            if (x.getAge() > 10) {
                oldCars1.add(x);
            }
        }
    return oldCars1;
    }
    public static void output(ArrayList<Vehicle> x){
        for (Vehicle y : x
        ) {
            System.out.println(y);
        }

    }


}
