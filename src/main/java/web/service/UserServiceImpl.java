package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private List<User> cars = new ArrayList<>();

    public UserServiceImpl() {
        cars.add(new User("Toyota", 1));
        cars.add(new User("HONDA", 22));
        cars.add(new User("lada", 333));
        cars.add(new User("BMW", 4_444));
        cars.add(new User("Audi", 55_555));
    }

    public List<User> getCars(int count) {
        return count >= 5
                ? cars
                : cars.stream().limit(count).collect(Collectors.toList());
    }
}
