package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static com.company.SerializeToXML.deserializeFromXML;
import static com.company.SerializeToXML.serializeToXML;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws IOException {
        Vehicle car = new Vehicle("BMW", "Mini", "11/09/2000");
        Vehicle car2 = new Car("Audi", "Aini", "11/09/2015", FuelType.GAS);
        Vehicle car3 = new Car("Ferrari", "Bini", "11/09/1997", FuelType.GAS);
        Vehicle car4 = new Car("BMW", "Cini", "11/09/1997", FuelType.GAS);
        ArrayList<Vehicle> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        System.out.println(ANSI_YELLOW + "+++++++++++++++++++++++++++++++++++" + ANSI_PURPLE + "Hi there!" + ANSI_YELLOW + "++++++++++++++++++++++++++++++++++++++");
        printOut();
        int param = scan.nextInt();
        while (param != 0) {
            switch (param) {
                case 1:
                    System.out.println("Enter a Vehicle to add :");
                    Vehicle v = new Vehicle();
                    v.inPut();
                    cars.add(v);
                    System.out.println("New vehicle was added");
                    param = scan.nextInt();
                    break;

                case 2:
                    System.out.println("Enter a Car to add :");
                    Vehicle s = new Car();
                    s.inPut();
                    cars.add(s);
                    System.out.println("Please choose an action by typing 0-6");
                    param = scan.nextInt();
                    break;
                case 3:
                    System.out.println(cars);
                    System.out.println("Please choose an action by typing 0-6");
                    param = scan.nextInt();
                    break;
                case 4:
                    System.out.println("Vehicles older than 10 years");
                    System.out.println(Vehicle.carsOlderThan10(cars));

                    System.out.println("Please choose an action by typing 0-6");
                    param = scan.nextInt();
                    break;

                case 5:
                    Collections.sort(cars, Vehicle.ModelComparator);
                    System.out.println("Vehicles sorted by Model: \n"+cars);
                    System.out.println("Please choose an action by typing 0-6");
                    param = scan.nextInt();
                    break;
                case 6:
                    Collections.sort(cars, Vehicle.BrandComparator);
                    System.out.println("Vehicles sorted by Brand: \n"+cars);
                    System.out.println("Please choose an action by typing 0-6");
                    param = scan.nextInt();
                    break;
                case 7:
                    serializeToXML(cars);
                    System.out.println("Cars is serialized");
                    System.out.println("Please choose an action by typing 0-6");
                    param = scan.nextInt();
                    break;
                case 8:
                    System.out.print("Deserialized Cars: \n");
                    System.out.println(deserializeFromXML());


                    System.out.println("Please choose an action by typing 0-6");
                    param = scan.nextInt();
                    break;
                case 9:
                    fileWrite(cars);
                    System.out.println("File is written");
                    System.out.println("Please choose an action by typing 0-6");
                    param = scan.nextInt();
                    break;

                default:
                    if (param > 9)
                        throw new IllegalStateException("Unexpected value: " + param);

            }
        }

      /*  ArrayList<Vehicle> cars = new ArrayList<>();
        cars.add(new Car());*/
        /*SerializeToXML.serializeToXML(cars);
        cars = SerializeToXML.deserializeFromXML();
        System.out.println(cars);

*/
        /*Collections.sort(cars,Vehicle.ModelComparator);
        for (Vehicle c :
                cars) {
            System.out.println(c);
        }
*/





       /* try {
            FileOutputStream fileOut = new FileOutputStream("test1");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cars);
            fileOut.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");
        }catch (IOException e){
            e.printStackTrace();
        }

        try
        {
            FileInputStream fileIn = new FileInputStream("test1");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            System.out.println("Deserialized data: "+in.readObject().toString());
            in.close();
            fileIn.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");
        }catch (IOException e){
            e.printStackTrace();
        }
*/














      /*  try {
            FileInputStream fileInputStream = new FileInputStream("test1");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                ArrayList<Vehicle> deserializedCar = (ArrayList) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }catch (IOException ioe)
        {
            ioe.printStackTrace();

        }*/

        // car.getAge();
        // Vehicle mini = new Car();
        // mini.inPut();
        /*car.inPut();
        System.out.println(car.toString());*/

       /* System.out.println( veh.getBrand());
        veh.inPut();
        System.out.println( veh.getBrand());
        veh_empty.setModel("Hhh");*/

    }


    /*
    Variant 3
            Define a class Vehicle which contains:
            -	Fields Brand, Model, ProductionDate
            -	Constructor with parameters
            -	Input() and output() methods for input/output from/to console
            -	Getters and setters
            -	Method GetAge() calculating the vehicle’s age in full years
            -	Overridden ToString() method
            Define a descendant class Car that has:
            -	Additional field FuelType
            -	Constructor with parameters
            -	Additional getter and setter
            -	Overridden input() and output() methods
            Create a collection of vehicles and add some different vehicles and cars to it.
            -	Output the data about vehicles elder than 10 years+
            -	Sort the data by brand and model
            -	Output the collection to a file   -
            -	Implement exception handling
            -	Serialize the collection to XML file  +
            -	Deserialize it back  +
            -	Write unit tests
    */

    private static void printOut() {
        System.out.println("\t\t\t\t\t\t\tPlease choose an action. Press : \n" + ANSI_YELLOW
                + ANSI_BLUE + "1 - To add a new Vehicle\n"
                + "2 - To add a new Car\n"
                + "3 - To wiew list of all Vehicles\n"
                + "4 - To wiew all Vehicles older than 10 years\n"
                + "5 - To sort all Vehicles by Model \n"
                + "6 - To sort all Vehicles by Brand \n"
                + "7 - To Serialize list of Vehicles\n"
                + "8 - To Deserialize Vehicles from file \n"
                + "9 - To Write list of Vehicles into file(txt) \n"
                + "press 0 to exit\n" + ANSI_RED
                + "\t\t\t After choosing an option please press enter" + ANSI_WHITE);
    }


    public static void fileWrite(ArrayList<Vehicle> carsWrite) throws IOException {
        FileWriter fw = new FileWriter("sample1.txt");
        for (Vehicle c :
                carsWrite) {
            fw.write(c.toString());
        }
        fw.close();
    }

}
