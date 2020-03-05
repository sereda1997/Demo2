import com.company.Car;
import com.company.FuelType;
import com.company.Vehicle;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class dataProvider {

    @DataProvider(name = "ListOfCars")
    public Object[][] getData() {
        ArrayList<Vehicle> cars = new ArrayList<>();
        Vehicle car = new Vehicle("BMW", "Mini", "11/09/2000");
        Vehicle car2 = new Car("Audi", "Aini", "11/09/2015", FuelType.GAS);
        Vehicle car3 = new Car("Ferrari", "Bini", "11/09/1997", FuelType.GAS);
        Vehicle car4 = new Car("BMW", "Cini", "11/09/1997", FuelType.GAS);
        cars.add(car);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        ArrayList<Vehicle> cars_sorted = new ArrayList<>();
        cars_sorted.add(car);
        cars_sorted.add(car3);
        cars_sorted.add(car4);
        Object[][] data = {{cars, cars_sorted}};
        return data;
    }

    @DataProvider(name = "Vehicles with age 22")
    public Object[][] cars() {
        Vehicle car3 = new Car("Ferrari", "Bini", "11/09/1997", FuelType.GAS);
        Vehicle car4 = new Car("BMW", "Cini", "11/09/1997", FuelType.GAS);
        Object[][] data = {{car3},{car4}};
        return data;
    }
}