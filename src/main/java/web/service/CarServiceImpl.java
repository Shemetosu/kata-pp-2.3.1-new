package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("Toyota", 1));
        cars.add(new Car("HONDA", 22));
        cars.add(new Car("lada", 333));
        cars.add(new Car("BMW", 4_444));
        cars.add(new Car("Audi", 55_555));
    }

    public List<Car> getCars(int count) {
        return count >= 5
                ? cars
                : cars.stream().limit(count).collect(Collectors.toList());
    }
}
