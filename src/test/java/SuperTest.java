import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.company.SerializeToXML;
import com.company.*;


import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.company.SerializeToXML.deserializeFromXML;
import static com.company.SerializeToXML.serializeToXML;
import static com.company.Vehicle.*;
import static org.testng.Assert.assertEquals;

public class SuperTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    @Test
    public void testIldCarsWiew(){// Checking carsOlder than
        Vehicle car = new Vehicle("BMW", "Mini", "11/09/1997");
        Vehicle car2 = new Vehicle("BMW", "Mini", "11/09/1997");
        Vehicle car3 = new Vehicle("BMW", "Mini", "11/09/2020");
        Vehicle car4 = new Vehicle("BMW", "Mini", "11/09/2020");
        ArrayList<Vehicle> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        ArrayList<Vehicle> cars2 = new ArrayList<>();
        cars2.add(car);
        cars2.add(car2);
        ArrayList<Vehicle> v ;
        v = Vehicle.carsOlderThan10(cars);
        assertEquals(v,cars2);

    }
    @Test
    public void testComparingCars (){
        Vehicle car = new Vehicle("BMW", "Mini", "11/09/1997");
        ArrayList<Vehicle> cars = new ArrayList<>();
        cars.add(car);
        int x =  ModelComparator.compare(car,car);
        assertEquals(x, 0);
    }
    @Test
    public void testAgeWiew (){
        Vehicle car = new Vehicle("BMW", "Mini", "11/09/1997");
        ArrayList<Vehicle> cars = new ArrayList<>();
        cars.add(car);
        LocalDate today = LocalDate.now();
        Period period = Period.between(LocalDate.parse(car.getDate(), formatter), today);
         int year = period.getYears();
        assertEquals(year , 22);
    }
   /* @Test
    public void tets2 () throws IOException {
        Vehicle car = new Vehicle("BMW", "Mini", "11/09/1997");
        Vehicle car3 = new Vehicle("BMW", "Mini", "11/09/2020");
        Vehicle car4 = new Vehicle("BMW", "Mini", "11/09/2020");
        ArrayList<Vehicle> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car3);
        cars.add(car4);

        SerializeToXML s =new SerializeToXML();
        serializeToXML(cars);
        ArrayList<Vehicle> cars3 ;
       cars3= deserializeFromXML();
        assertEquals(cars,cars3);
    }*/
}
/*import static org.testng.Assert.assertEquals;

public class SerializerTest {

    @Test
    void deserialize() {
        //Arrange
        Serializer serializer = new Serializer();
        ArrayList<Animal> myAnimals = new ArrayList<>();
        myAnimals.add(new Animal(2018, "brown"));
        myAnimals.add(new Animal(2013, "black"));
        String s = "[I'm moving!, I'm moving!]";
        ArrayList<Animal> serializedAnimal = null;
        //Act
        try {
            serializer.serialize(myAnimals);
            serializedAnimal = serializer.deserialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Assert
        assertEquals(serializedAnimal.toString(), s);
    }
}
import static org.testng.Assert.assertEquals;

public class ComparatorTest {
    @Test
    void compareTwoAnimals() {
        //Arrange
        AnimalComparator com = new AnimalComparator();
        Animal cat = new Animal(2011, "brown");
        Animal dog = new Animal(2015, "black");
        //Act
        int result = com.compare(cat, dog);
        //Assert
        assertEquals(result, 0);

    }

    @Test
    void compareAnimalFish(){
        //Arrange
        AnimalComparator com = new AnimalComparator();
        Animal dog = new Animal(2015, "black");
        Fish firstFish = new Fish(2018, "gold", "river", "gold fish");
        //Act
        int result = com.compare(firstFish, dog);
        //Assert
        assertEquals(result, 0);
    }
}*/