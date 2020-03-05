import org.testng.annotations.Test;
import com.company.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static com.company.Vehicle.*;
import static org.testng.Assert.assertEquals;

public class SuperTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Test(dataProvider = "ListOfCars", dataProviderClass = dataProvider.class)
    public void testIldCarsWiew(ArrayList<Vehicle> list, ArrayList<Vehicle> sortedList) {// Checking carsOlder than 10
        ArrayList<Vehicle> result;
        result = Vehicle.carsOlderThan10(list);
        assertEquals(result, sortedList);
    }

    @Test
    public void testComparingCars() {
        Vehicle car = new Vehicle("BMW", "Mini", "11/09/1997");
        ArrayList<Vehicle> cars = new ArrayList<>();
        cars.add(car);
        int x = ModelComparator.compare(car, car);
        assertEquals(x, 0);
    }

    @Test(dataProvider = "Vehicles with age 22", dataProviderClass = dataProvider.class)
    public void testAgeWiew(Vehicle x) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(LocalDate.parse(x.getDate(), formatter), today);
        int year = period.getYears();
        assertEquals(year, 22);
    }

}