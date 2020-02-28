package com.company;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

 public class SerializeToXML {

       public static void serializeToXML(ArrayList<Vehicle> carSerialize)throws IOException {

        FileOutputStream fos = new FileOutputStream("settings.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(carSerialize);
        encoder.close();
        fos.close();
        System.out.println("Succesfully serialized");
    }
      public static ArrayList<Vehicle>  deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("settings.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        ArrayList<Vehicle> decodedSettings = (ArrayList<Vehicle>) decoder.readObject();
        decoder.close();
        fis.close();
        System.out.println("Succesfully deserialized");

        return  decodedSettings;

    }

}
